package com.example.backend.repo

import com.example.backend.model.Comment
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentRepository : ReactiveMongoRepository<Comment, String> {
}