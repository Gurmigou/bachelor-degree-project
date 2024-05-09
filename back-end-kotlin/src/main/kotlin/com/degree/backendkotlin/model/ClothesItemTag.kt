package com.degree.backendkotlin.model

import jakarta.persistence.*

@Entity
class ClothesItemTag(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "clothesItemId", nullable = false)
        val clothesItem: ClothesItem,

        var tag: String
)