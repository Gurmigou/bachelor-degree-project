package com.degree.backendkotlin.dto.preview

import com.degree.backendkotlin.dto.FilePreviewDto

data class OutfitClothesPreviewDto(
    val headdress: FilePreviewDto,
    val torso: FilePreviewDto,
    val legwear: FilePreviewDto,
    val feet: FilePreviewDto,
    val accessories: FilePreviewDto
)
