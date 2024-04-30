package com.example.backend.model

import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "comments")
data class Comment(
        val author: User,
        val commentText: String,
        val rate: Rate,
        val dateOfCreation: LocalDateTime
)
