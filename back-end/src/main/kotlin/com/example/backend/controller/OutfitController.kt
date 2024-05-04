package com.example.backend.controller

import Outfit
import com.example.backend.dto.OutfitDto
import com.example.backend.service.OutfitService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/outfits")
class OutfitController(private val outfitService: OutfitService) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createOutfit(@RequestBody outfitDto: OutfitDto): Mono<Outfit> {
        return outfitService.saveOutfit(outfitDto, 1L)
    }

    @PutMapping("/{id}")
    fun updateOutfit(@PathVariable id: Long, @RequestBody outfit: Outfit): Mono<Outfit> {
        return outfitService.updateOutfit(id, outfit)
    }

    @GetMapping("/{id}")
    fun getOutfitById(@PathVariable id: Long): Mono<Outfit> {
        return outfitService.getOutfitById(id)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteOutfitById(@PathVariable id: Long): Mono<Void> {
        return outfitService.deleteOutfitById(id)
    }
}
