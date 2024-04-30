package com.example.backend.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "clothesItems")
data class ClothesItem(
        @Id
        val id: String? = null,
        val name: String,
        val description: String,
        val photos: List<String>,
        val type: ClothesItemType
)