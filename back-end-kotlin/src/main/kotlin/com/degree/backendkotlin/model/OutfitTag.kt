package com.degree.backendkotlin.model

import jakarta.persistence.*

@Entity
class OutfitTag(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "outfitId", nullable = false)
        val outfit: Outfit?,

        var tag: String
)