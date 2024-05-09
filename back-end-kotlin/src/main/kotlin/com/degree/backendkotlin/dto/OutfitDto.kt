package com.degree.backendkotlin.dto

data class OutfitDto(
        val id: Long? = null,
        val tags: List<String>,
        val name: String,
        val outfitClothes: OutfitClothesDto
)
