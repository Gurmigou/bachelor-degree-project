package com.example.backend.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table


@Table("clothes_items")
data class ClothesItem(
        @Id
        val id: Long? = null,
        val name: String = "",
        val description: String = "",
        val typeId: String,
        val outfitId: Long? = null
)