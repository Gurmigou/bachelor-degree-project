package com.example.backend.dto

data class ClothesElementDto(
        val id: Long? = null,
        val clothesElementName: String,
        val images: List<FilePreviewDto>,
        val description: String,
        val type: String,
)
