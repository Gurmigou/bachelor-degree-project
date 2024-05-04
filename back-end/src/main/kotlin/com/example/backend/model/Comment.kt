package com.example.backend.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("comments")
data class Comment(
        @Id
        val id: Long? = null,

        @Column("user_id")
        val userId: Long,

        @Column("outfit_id")
        val outfitId: Long,

        val commentText: String = "",
        val rate: String,
        val dateOfCreation: LocalDateTime = LocalDateTime.now()
)
