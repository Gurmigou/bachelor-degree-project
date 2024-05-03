//package com.example.backend.repo
//
//import com.example.backend.model.Outfit
//import org.springframework.data.repository.reactive.ReactiveCrudRepository
//import org.springframework.stereotype.Repository
//import reactor.core.publisher.Flux
//
//@Repository
//interface OutfitRepository : ReactiveCrudRepository<Outfit, Long> {
//    fun findByTagsContains(tag: String): Flux<Outfit>
//}
