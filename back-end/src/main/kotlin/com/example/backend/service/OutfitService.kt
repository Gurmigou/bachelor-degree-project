package com.example.backend.service

import Outfit
import com.example.backend.dto.ClothesElementDto
import com.example.backend.dto.FilePreviewDto
import com.example.backend.dto.OutfitClothesDto
import com.example.backend.dto.OutfitDto
import com.example.backend.model.ClothesItem
import com.example.backend.model.ClothesPhoto
import com.example.backend.model.OutfitTag
import com.example.backend.repo.ClothesItemRepository
import com.example.backend.repo.ClothesPhotoRepository
import com.example.backend.repo.OutfitRepository
import com.example.backend.repo.OutfitTagRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class OutfitService @Autowired constructor(
        private val outfitRepository: OutfitRepository,
        private val outfitTagRepository: OutfitTagRepository,
        private val clothesItemRepository: ClothesItemRepository,
        private val clothesPhotoRepository: ClothesPhotoRepository
) {
    fun saveOutfit(outfitDto: OutfitDto, userId: Long): Mono<Outfit> {
        val outfit = Outfit(name = outfitDto.name, userId = userId)
        return outfitRepository.save(outfit)
                .flatMap { savedOutfit ->
                    saveTags(outfitDto.tags, savedOutfit.id!!)
                            .then(saveClothes(outfitDto.outfitClothes, savedOutfit.id!!))
                            .thenReturn(savedOutfit)
                }
    }

    private fun saveTags(tags: List<String>, outfitId: Long): Flux<OutfitTag> =
            Flux.fromIterable(tags)
                    .flatMap { tag ->
                        outfitTagRepository.save(OutfitTag(outfitId = outfitId, tag = tag))
                    }

    private fun saveClothes(outfitClothesDto: OutfitClothesDto, outfitId: Long): Mono<Void> {
        return Flux.merge(
                saveClothesElements(outfitClothesDto.headdress, "headdress", outfitId),
                saveClothesElements(outfitClothesDto.torso, "torso", outfitId),
                saveClothesElements(outfitClothesDto.legwear, "legwear", outfitId),
                saveClothesElements(outfitClothesDto.feet, "feet", outfitId),
                saveClothesElements(outfitClothesDto.accessories, "accessories", outfitId)
        ).then()
    }

    private fun saveClothesElements(elements: List<ClothesElementDto>, type: String, outfitId: Long): Flux<ClothesItem> =
            Flux.fromIterable(elements)
                    .flatMap { element ->
                        clothesItemRepository.save(
                                ClothesItem(name = element.clothesElementName, description = element.description, typeId = type, outfitId = outfitId)
                        ).flatMap { savedItem ->
                            savePhotos(element.images, savedItem.id!!)
                                    .thenReturn(savedItem)
                        }
                    }

    private fun savePhotos(images: List<FilePreviewDto>, clothesItemId: Long): Mono<Void> =
            Flux.fromIterable(images)
                    .flatMap { image ->
                        clothesPhotoRepository.save(ClothesPhoto(clothesItemId = clothesItemId, photo = image.preview))
                    }.then()


    fun updateOutfit(id: Long, outfit: Outfit): Mono<Outfit> {
        return outfitRepository.findById(id)
                .flatMap {
                    outfit.id = id // Set the ID to ensure it updates the correct outfit
                    outfitRepository.save(outfit)
                }
    }

    fun getOutfitById(id: Long): Mono<Outfit> {
        return outfitRepository.findById(id)
    }

    fun deleteOutfitById(id: Long): Mono<Void> {
        return outfitRepository.deleteById(id)
    }
}
