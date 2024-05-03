package com.example.backend.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("CLOTHES_PHOTOS")
data class ClothesPhoto(
        @Id
        val id: Long? = null,

        @Column("clothes_item_id")
        val clothesItemId: Long,

        val photo: String
)