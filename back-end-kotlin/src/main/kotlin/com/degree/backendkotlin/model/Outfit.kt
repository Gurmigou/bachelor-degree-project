package com.degree.backendkotlin.model

import jakarta.persistence.*

@Entity
class Outfit(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        var name: String,

        var isFavorite: Boolean = false,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "userId", nullable = false)
        var user: User,

        @OneToMany(mappedBy = "outfit", cascade = [CascadeType.ALL], orphanRemoval = true)
        var clothesItems: MutableList<ClothesItem> = mutableListOf(),

        @OneToMany(mappedBy = "outfit", cascade = [CascadeType.ALL], orphanRemoval = true)
        var comments: MutableList<Comment> = mutableListOf(),

        @OneToMany(mappedBy = "outfit", cascade = [CascadeType.ALL], orphanRemoval = true)
        var tags: MutableList<OutfitTag> = mutableListOf()
)