package com.example.backend.service

import com.example.backend.model.ClothesItem
import com.example.backend.repo.ClothesItemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ClothesElementService @Autowired constructor(
        private val clothesItemRepository: ClothesItemRepository
) {
    fun createClothesElement(clothesItem: ClothesItem) {
        clothesItemRepository.save(clothesItem).subscribe()
    }
}