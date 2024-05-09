package com.degree.backendkotlin.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class User(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        var nickname: String,

        var email: String,

        var password: String,

        var registrationDate: LocalDateTime = LocalDateTime.now(),

        @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
        var outfits: MutableList<Outfit> = mutableListOf()
)