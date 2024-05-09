package com.degree.backendkotlin.model

import jakarta.persistence.*

@Entity
class ClothesPhoto(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "clothesItemId", nullable = false)
        val clothesItem: ClothesItem,

        var photo: String
)