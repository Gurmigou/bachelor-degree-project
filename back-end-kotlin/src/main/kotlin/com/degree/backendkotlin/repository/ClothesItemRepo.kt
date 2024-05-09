package com.degree.backendkotlin.repository

import com.degree.backendkotlin.model.ClothesItem
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ClothesItemRepo : CrudRepository<ClothesItem, Long> {
}