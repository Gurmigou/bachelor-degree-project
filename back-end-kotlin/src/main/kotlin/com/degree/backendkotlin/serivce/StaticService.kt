package com.degree.backendkotlin.serivce

import com.degree.backendkotlin.dto.LabelCountDto
import com.degree.backendkotlin.repository.ClothesItemRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StaticService(@Autowired private val clothesItemRepo: ClothesItemRepo) {
    fun getBrandNames(): List<LabelCountDto> {
        return clothesItemRepo.findLabelCountGroupedByBrand()
    }

    fun getTagNames(): List<LabelCountDto> {
        return clothesItemRepo.findLabelCountGroupedByTag()
    }
}