package com.example.backend.repo

import com.example.backend.model.ClothesPhoto
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ClothesPhotoRepository : ReactiveCrudRepository<ClothesPhoto, Long> {
}