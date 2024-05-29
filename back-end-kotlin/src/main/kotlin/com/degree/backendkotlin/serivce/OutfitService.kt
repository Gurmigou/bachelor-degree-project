package com.degree.backendkotlin.serivce

import com.degree.backendkotlin.dto.*
import com.degree.backendkotlin.dto.details.OutfitDetailsDto
import com.degree.backendkotlin.dto.preview.OutfitClothesPreviewDto
import com.degree.backendkotlin.dto.preview.OutfitPreviewDto
import com.degree.backendkotlin.dto.rate.PreviewFavoriteDto
import com.degree.backendkotlin.model.*
import com.degree.backendkotlin.repository.ClothesItemRepo
import com.degree.backendkotlin.repository.ClothesPhotoRepo
import com.degree.backendkotlin.repository.OutfitRepo
import com.degree.backendkotlin.repository.OutfitTagRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OutfitService @Autowired constructor(
    private val outfitRepository: OutfitRepo,
    private val outfitTagRepository: OutfitTagRepo,
    private val clothesItemRepository: ClothesItemRepo,
    private val clothesPhotoRepository: ClothesPhotoRepo,
    private val userService: UserService,
    private val commentService: CommentService
) {
    @Transactional
    fun saveOutfit(outfitDto: OutfitDto, userId: Long): Outfit {
        val outfit = Outfit(
            name = outfitDto.name,
            user = userService.getUser(userId),
        )
        val savedOutfit = outfitRepository.save(outfit)

        val clothesItems = getClothesItems(outfitDto.outfitClothes, savedOutfit)
        savedOutfit.clothesItems.addAll(clothesItems)

        val tags = getTags(outfitDto.tags, savedOutfit)
        savedOutfit.tags.addAll(tags)
        return outfitRepository.save(savedOutfit)
    }

    @Transactional
    fun updateOutfit(outfitDto: OutfitDto): Outfit {
        val outfit =
            outfitRepository.findById(outfitDto.id ?: throw IllegalArgumentException("Outfit ID must not be null"))
                .orElseThrow { RuntimeException("Outfit not found with id: ${outfitDto.id}") }
        outfit.name = outfitDto.name

        updateTags(outfit, outfitDto.tags)
        updateClothesItems(outfit, outfitDto.outfitClothes)

        return outfitRepository.save(outfit)
    }

    @Transactional
    fun deleteOutfit(outfitId: Long) {
        val outfit = outfitRepository.findById(outfitId).orElseThrow {
            RuntimeException("Outfit not found with id: $outfitId")
        }
        outfitRepository.delete(outfit)
    }


    @Transactional
    fun setIsFavorite(previewFavoriteDto: PreviewFavoriteDto) {
        val outfit = outfitRepository.findById(previewFavoriteDto.outfitId).orElseThrow {
            RuntimeException("Outfit not found with id: ${previewFavoriteDto.outfitId}")
        }
        outfit.isFavorite = previewFavoriteDto.isFavorite
        outfitRepository.save(outfit)
    }

    private fun updateTags(outfit: Outfit, newTags: List<String>) {
        outfitTagRepository.deleteAll(outfit.tags)
        val updatedTags = newTags.map { tagName ->
            OutfitTag(tag = tagName, outfit = outfit)
        }
        outfit.tags.clear()
        outfit.tags.addAll(outfitTagRepository.saveAll(updatedTags))
    }

    private fun updateClothesItems(outfit: Outfit, outfitClothesDto: OutfitClothesDto) {
        clothesItemRepository.deleteAll(outfit.clothesItems)
        val updatedItems = getClothesItems(outfitClothesDto, outfit)
        outfit.clothesItems.clear()
        outfit.clothesItems.addAll(clothesItemRepository.saveAll(updatedItems))
    }

    private fun getTags(tags: List<String>, outfit: Outfit): MutableList<OutfitTag> {
        return tags.map { tag ->
            OutfitTag(tag = tag, outfit = outfit)
        }.toMutableList()
    }

    private fun getClothesItems(outfitClothes: OutfitClothesDto, outfit: Outfit): MutableList<ClothesItem> {
        val clothesItems = mutableListOf<ClothesItem>()
        clothesItems.addAll(getClothesElements(outfitClothes.headdress, ClothesItemType.HEADDRESS, outfit))
        clothesItems.addAll(getClothesElements(outfitClothes.torso, ClothesItemType.TORSO, outfit))
        clothesItems.addAll(getClothesElements(outfitClothes.legwear, ClothesItemType.LEGWEAR, outfit))
        clothesItems.addAll(getClothesElements(outfitClothes.feet, ClothesItemType.FEET, outfit))
        clothesItems.addAll(getClothesElements(outfitClothes.accessories, ClothesItemType.ACCESSORIES, outfit))
        return clothesItems
    }

    private fun getClothesElements(
        elements: List<ClothesElementDto>,
        type: ClothesItemType,
        outfit: Outfit
    ): List<ClothesItem> {
        val clothesItems = mutableListOf<ClothesItem>()
        elements.forEach { element ->
            val clothesItem = ClothesItem(
                name = element.clothesElementName,
                description = element.description,
                type = type,
                outfit = outfit,
                brand = element.brand
            )
            clothesItem.photos = getPhotos(element.images, clothesItem)
            clothesItems.add(clothesItem)
        }
        return clothesItems
    }

    private fun getPhotos(images: List<FilePreviewDto>, clothesItem: ClothesItem): MutableList<ClothesPhoto> {
        val clothesPhotos = mutableListOf<ClothesPhoto>()
        images.forEach { image ->
            clothesPhotos.add(ClothesPhoto(photo = image.preview.toByteArray(), clothesItem = clothesItem))
        }
        return clothesPhotos
    }

    fun getOutfitById(outfitId: Long): OutfitDetailsDto {
        val outfit =
            outfitRepository.findById(outfitId).orElseThrow { RuntimeException("Outfit not found with id: $outfitId") }
        return OutfitDetailsDto(
            id = outfit.id,
            name = outfit.name,
            tags = outfit.tags.map { it.tag },
            outfitClothes = getOutfitClothes(outfit.clothesItems),
            comments = commentService.getCommentsByOutfitId(outfitId),
            designerName = outfit.user.nickname,
            isFavorite = outfit.isFavorite,
            rate = commentService.getAverageRateForOutfit(outfit),
            numberOfComments = commentService.getNumberOfCommentsForOutfit(outfit)
        )
    }

    private fun getOutfitClothes(clothesItems: List<ClothesItem>): OutfitClothesDto {
        val outfitClothes = OutfitClothesDto(
            headdress = mutableListOf(),
            torso = mutableListOf(),
            legwear = mutableListOf(),
            feet = mutableListOf(),
            accessories = mutableListOf()
        )
        clothesItems.forEach { clothesItem ->
            when (clothesItem.type) {
                ClothesItemType.HEADDRESS -> outfitClothes.headdress.add(getClothesElement(clothesItem))
                ClothesItemType.TORSO -> outfitClothes.torso.add(getClothesElement(clothesItem))
                ClothesItemType.LEGWEAR -> outfitClothes.legwear.add(getClothesElement(clothesItem))
                ClothesItemType.FEET -> outfitClothes.feet.add(getClothesElement(clothesItem))
                ClothesItemType.ACCESSORIES -> outfitClothes.accessories.add(getClothesElement(clothesItem))
            }
        }
        return outfitClothes
    }

    private fun getClothesElement(clothesItem: ClothesItem): ClothesElementDto {
        return ClothesElementDto(
            id = clothesItem.id,
            clothesElementName = clothesItem.name,
            description = clothesItem.description,
            images = getImages(clothesItem.photos),
            type = clothesItem.type.toString(),
            brand = clothesItem.brand
        )
    }

    private fun getImages(photos: List<ClothesPhoto>): List<FilePreviewDto> {
        val images = mutableListOf<FilePreviewDto>()
        photos.forEach { photo ->
            images.add(
                FilePreviewDto(
                    name = "",
                    preview = String(photo.photo, Charsets.UTF_8)
                )
            )
        }
        return images
    }

    fun getAllOutfitsPreview(): List<OutfitPreviewDto> {
        val outfits = outfitRepository.findAll().toList()
        return getPreviewOutfits(outfits)
    }

    fun getAllOutfitsPreviewForUser(userId: Long): List<OutfitPreviewDto> {
        val outfits = outfitRepository.findAllByUserId(userId).toList()
        return getPreviewOutfits(outfits)
    }

    private fun getPreviewOutfits(outfits: List<Outfit>): List<OutfitPreviewDto> {
        return outfits.map { outfit ->
            OutfitPreviewDto(
                id = outfit.id,
                designerName = outfit.user.nickname,
                numberOfComments = commentService.getNumberOfCommentsForOutfit(outfit),
                rate = commentService.getAverageRateForOutfit(outfit),
                outfitClothesPreview = getOutfitClothesPreview(outfit.clothesItems),
                isFavorite = outfit.isFavorite
            )
        }
    }

    private fun getOutfitClothesPreview(clothesItems: MutableList<ClothesItem>): OutfitClothesPreviewDto {
        val typeToPhotoMap = clothesItems.groupBy { it.type }.mapValues { entry ->
            entry.value.flatMap { clothesItem ->
                clothesItem.photos
            }.minByOrNull { photo ->
                photo.id ?: Long.MAX_VALUE
            }?.photo
        }
        return OutfitClothesPreviewDto(
            headdress = FilePreviewDto(
                name = "",
                preview = String(typeToPhotoMap[ClothesItemType.HEADDRESS] ?: byteArrayOf(), Charsets.UTF_8)
            ),
            torso = FilePreviewDto(
                name = "",
                preview = String(typeToPhotoMap[ClothesItemType.TORSO] ?: byteArrayOf(), Charsets.UTF_8)
            ),
            legwear = FilePreviewDto(
                name = "",
                preview = String(typeToPhotoMap[ClothesItemType.LEGWEAR] ?: byteArrayOf(), Charsets.UTF_8)
            ),
            feet = FilePreviewDto(
                name = "",
                preview = String(typeToPhotoMap[ClothesItemType.FEET] ?: byteArrayOf(), Charsets.UTF_8)
            ),
            accessories = FilePreviewDto(
                name = "",
                preview = String(typeToPhotoMap[ClothesItemType.ACCESSORIES] ?: byteArrayOf(), Charsets.UTF_8)
            )
        )
    }

    fun getOutfitsByFilter(brands: Set<String>, tags: Set<String>): List<OutfitPreviewDto> {
        return outfitRepository.findAllWithFilers(brands, tags).map { outfit ->
            OutfitPreviewDto(
                id = outfit.id,
                designerName = outfit.user.nickname,
                numberOfComments = commentService.getNumberOfCommentsForOutfit(outfit),
                rate = commentService.getAverageRateForOutfit(outfit),
                outfitClothesPreview = getOutfitClothesPreview(outfit.clothesItems),
                isFavorite = outfit.isFavorite
            )
        }
    }

    fun deleteFromFavorites(outfitId: Long) {
        val outfit = outfitRepository.findById(outfitId).orElseThrow {
            RuntimeException("Outfit not found with id: $outfitId")
        }
        outfit.isFavorite = false
        outfitRepository.save(outfit)
    }
}