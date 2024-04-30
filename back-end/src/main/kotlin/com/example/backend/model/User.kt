package com.example.backend.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "users")
data class User(
        @Id
        val id: String? = null,
        val nickname: String,
        val email: String,
        val password: String,
        val registrationDate: LocalDateTime
)
