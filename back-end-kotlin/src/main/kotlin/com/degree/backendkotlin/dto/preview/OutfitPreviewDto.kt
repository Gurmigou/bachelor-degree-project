package com.degree.backendkotlin.dto.preview

import com.degree.backendkotlin.model.Rate

data class OutfitPreviewDto(
    val id: Long?,
    val designerName: String,
    val numberOfComments: Long,
    val rate: Rate,
    val isFavorite: Boolean,
    val outfitClothesPreview: OutfitClothesPreviewDto
)
