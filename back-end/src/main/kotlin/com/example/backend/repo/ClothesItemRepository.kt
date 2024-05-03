package com.example.backend.repo

import com.example.backend.model.ClothesItem
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface ClothesItemRepository : ReactiveCrudRepository<ClothesItem, Long> {
}