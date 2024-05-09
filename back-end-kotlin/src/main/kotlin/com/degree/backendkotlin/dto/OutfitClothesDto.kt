package com.degree.backendkotlin.dto

data class OutfitClothesDto(
        val headdress: MutableList<ClothesElementDto>,
        val torso: MutableList<ClothesElementDto>,
        val legwear: MutableList<ClothesElementDto>,
        val feet: MutableList<ClothesElementDto>,
        val accessories: MutableList<ClothesElementDto>
)
