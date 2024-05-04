package com.example.backend.dto

data class OutfitClothesDto(
        val headdress: List<ClothesElementDto>,
        val torso: List<ClothesElementDto>,
        val legwear: List<ClothesElementDto>,
        val feet: List<ClothesElementDto>,
        val accessories: List<ClothesElementDto>
)
