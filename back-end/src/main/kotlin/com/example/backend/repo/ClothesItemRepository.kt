package com.example.backend.repo

import com.example.backend.model.ClothesItem
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ClothesItemRepository : ReactiveMongoRepository<ClothesItem, String> {
}