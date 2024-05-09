package com.degree.backendkotlin.model

import jakarta.persistence.*

@Entity
class ClothesItem(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        var name: String,

        var description: String,

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        var type: ClothesItemType,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "outfitId")
        var outfit: Outfit,

        @OneToMany(mappedBy = "clothesItem", cascade = [CascadeType.ALL], orphanRemoval = true)
        var photos: MutableList<ClothesPhoto> = mutableListOf(),

        @OneToMany(mappedBy = "clothesItem", cascade = [CascadeType.ALL], orphanRemoval = true)
        var tags: MutableList<ClothesItemTag> = mutableListOf()
)