package com.degree.backendkotlin.dto

import com.degree.backendkotlin.model.Rate
import java.time.LocalDateTime

data class CommentDto(
    val userId: Long?,
    val username: String?,
    val commentText: String,
    val rate: Rate,
    val dateOfCreation: LocalDateTime? = null
)
