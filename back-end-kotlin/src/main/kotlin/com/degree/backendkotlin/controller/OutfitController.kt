package com.degree.backendkotlin.controller

import com.degree.backendkotlin.dto.CommentDto
import com.degree.backendkotlin.dto.FilterDto
import com.degree.backendkotlin.dto.OutfitDto
import com.degree.backendkotlin.dto.preview.OutfitPreviewDto
import com.degree.backendkotlin.dto.rate.PreviewFavoriteDto
import com.degree.backendkotlin.serivce.CommentService
import com.degree.backendkotlin.serivce.OutfitService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin("*")
@RestController
@RequestMapping("/outfits")
class OutfitController(
    @Autowired
    private val outfitService: OutfitService,
    private val commentService: CommentService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createOutfit(@RequestBody outfitDto: OutfitDto): ResponseEntity<String> {
        outfitService.saveOutfit(outfitDto, 1L)
        return ResponseEntity.ok("Outfit created")
    }

    @PostMapping("/{outfitId}/comments")
    @ResponseStatus(HttpStatus.CREATED)
    fun addCommentToOutfit(
        @PathVariable outfitId: Long,
        @RequestBody commentDto: CommentDto
    ): ResponseEntity<String> {
        commentService.addCommentToOutfit(outfitId, commentDto)
        return ResponseEntity.ok("Comment added")
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun updateOutfit(@RequestBody outfitDto: OutfitDto): ResponseEntity<String> {
        outfitService.updateOutfit(outfitDto)
        return ResponseEntity.ok("Outfit updated")
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    fun deleteOutfit(@RequestParam outfitId: Long): ResponseEntity<String> {
        outfitService.deleteOutfit(outfitId)
        return ResponseEntity.ok("Outfit deleted")
    }

    @GetMapping("/{id}")
    fun getOutfitById(@PathVariable id: Long): OutfitDto {
        return outfitService.getOutfitById(id)
    }

    @GetMapping("/all-preview")
    fun getAllOutfitsPreview(): List<OutfitPreviewDto> {
        return outfitService.getAllOutfitsPreview()
    }

    @GetMapping("/all-preview-user")
    fun getAllOutfitsPreviewForUser(@RequestParam userId: Long): List<OutfitPreviewDto> {
        return outfitService.getAllOutfitsPreviewForUser(userId)
    }

    @GetMapping("/all-preview-filters")
    fun getAllOutfitsPreviewWithFilters(@RequestParam brands: Set<String>,
                                        @RequestParam tags: Set<String>): List<OutfitPreviewDto> {
        return outfitService.getOutfitsByFilter(brands, tags)
    }

    @PutMapping("/favorite")
    @ResponseStatus(HttpStatus.OK)
    fun favoriteOutfit(@RequestBody previewFavoriteDto: PreviewFavoriteDto) {
        outfitService.setIsFavorite(previewFavoriteDto);
    }
}
