package com.degree.backendkotlin.repository

import com.degree.backendkotlin.model.ClothesItemTag
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ClothesItemTagRepo : CrudRepository<ClothesItemTag, Long> {
}