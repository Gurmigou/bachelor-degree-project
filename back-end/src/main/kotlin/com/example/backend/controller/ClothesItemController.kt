package com.example.backend.controller

import com.example.backend.model.ClothesItem
import com.example.backend.service.ClothesElementService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/clothes")
class ClothesItemController(private val clothesElementService: ClothesElementService) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createClothesItem() {
        val newItem = ClothesItem(
                name = "Mock T-Shirt",
                description = "A plain white cotton t-shirt",
                typeId = "TORSO"
        )
        clothesElementService.createClothesElement(newItem)
    }
}