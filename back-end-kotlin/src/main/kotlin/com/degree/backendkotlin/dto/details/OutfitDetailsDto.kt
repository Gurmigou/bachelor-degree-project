package com.degree.backendkotlin.dto.details

import com.degree.backendkotlin.dto.CommentDto
import com.degree.backendkotlin.dto.OutfitClothesDto
import com.degree.backendkotlin.model.Rate

data class OutfitDetailsDto (
    val id: Long? = null,
    val name: String,
    val tags: List<String>,
    val outfitClothes: OutfitClothesDto,
    val comments: List<CommentDto>,
    val designerName: String,
    val isFavorite: Boolean,
    val rate: Rate,
    val numberOfComments: Long
)