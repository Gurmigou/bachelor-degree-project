package com.example.backend.repo

import com.example.backend.model.OutfitTag
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface OutfitTagRepository : ReactiveCrudRepository<OutfitTag, Long> {
}