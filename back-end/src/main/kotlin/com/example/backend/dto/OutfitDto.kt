package com.example.backend.dto

data class OutfitDto(
        val id: Long? = null,
        val tags: List<String>,
        val name: String,
        val outfitClothes: OutfitClothesDto
)
