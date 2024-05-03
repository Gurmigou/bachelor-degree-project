//package com.example.backend.service
//
//import com.example.backend.model.Outfit
//import com.example.backend.repo.OutfitRepository
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.stereotype.Service
//import reactor.core.publisher.Mono
//
//@Service
//class OutfitService @Autowired constructor(
//        private val outfitRepository: OutfitRepository
//) {
//
//    fun saveOutfit(outfit: Outfit): Mono<Outfit> {
//        return outfitRepository.save(outfit)
//    }
//
//    fun updateOutfit(id: Long, outfit: Outfit): Mono<Outfit> {
//        return outfitRepository.findById(id)
//                .flatMap {
//                    outfit.id = id // Set the ID to ensure it updates the correct outfit
//                    outfitRepository.save(outfit)
//                }
//    }
//
//    fun getOutfitById(id: Long): Mono<Outfit> {
//        return outfitRepository.findById(id)
//    }
//
//    fun deleteOutfitById(id: Long): Mono<Void> {
//        return outfitRepository.deleteById(id)
//    }
//}
