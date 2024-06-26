package com.degree.backendkotlin.dto

data class ClothesElementDto(
        val id: Long? = null,
        val clothesElementName: String,
        val brand: String,
        val images: List<FilePreviewDto>,
        val description: String,
        val type: String,
)
