package com.degree.backendkotlin.repository

import com.degree.backendkotlin.model.ClothesPhoto
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ClothesPhotoRepo : CrudRepository<ClothesPhoto, Long> {
}