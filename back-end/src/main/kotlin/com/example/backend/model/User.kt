package com.example.backend.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("users")
data class User(
        @Id
        val id: Long? = null,
        val nickname: String = "",
        val email: String = "",
        val password: String = "",
        val registrationDate: LocalDateTime = LocalDateTime.now()
)
