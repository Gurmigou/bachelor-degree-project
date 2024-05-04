package com.example.backend.repo

import Outfit
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface OutfitRepository : ReactiveCrudRepository<Outfit, Long> {
}
