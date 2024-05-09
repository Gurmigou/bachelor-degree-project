package com.degree.backendkotlin.dto.preview

import com.degree.backendkotlin.model.Rate

data class OutfitPreviewDto(
    val designerName: String,
    val numberOfComments: Long,
    val rate: Rate,
    val outfitClothesPreviewDto: OutfitClothesPreviewDto
)
