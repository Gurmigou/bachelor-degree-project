package com.example.backend.repo

import com.example.backend.model.Outfit
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface OutfitRepository : ReactiveMongoRepository<Outfit, String> {
    fun findByTagsContaining(tag: String): Flux<Outfit>
}