package com.example.backend.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "outfits")
data class Outfit(
        @Id
        val id: String? = null,
        val name: String,
        val tags: List<String>,
        val headdress: List<ClothesItem>,
        val torso: List<ClothesItem>,
        val legwear: List<ClothesItem>,
        val feet: List<ClothesItem>,
        val accessories: List<ClothesItem>,
        val comments: List<Comment>
)