package com.degree.backendkotlin.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class Comment(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "userId", nullable = false)
        val user: User,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "outfitId", nullable = false)
        val outfit: Outfit,

        var commentText: String = "",

        @Enumerated(EnumType.STRING)
        var rate: Rate,

        var dateOfCreation: LocalDateTime = LocalDateTime.now()
)