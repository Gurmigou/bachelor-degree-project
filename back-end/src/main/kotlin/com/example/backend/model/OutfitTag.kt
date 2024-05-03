package com.example.backend.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("OUTFIT_TAGS")
data class OutfitTag(
        @Id
        val id: Long? = null,

        @Column("outfit_id")
        val outfitId: Long,

        val tag: String
)
