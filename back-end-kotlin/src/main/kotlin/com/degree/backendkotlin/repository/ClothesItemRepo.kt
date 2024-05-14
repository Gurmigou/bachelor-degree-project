package com.degree.backendkotlin.repository

import com.degree.backendkotlin.dto.LabelCountDto
import com.degree.backendkotlin.model.ClothesItem
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ClothesItemRepo : CrudRepository<ClothesItem, Long> {

    @Query("""
        SELECT new com.degree.backendkotlin.dto.LabelCountDto(CI.brand, COUNT(CI.id))
        FROM ClothesItem CI
        GROUP BY CI.brand
    """)
    fun findLabelCountGroupedByBrand(): List<LabelCountDto>

    @Query("""
        SELECT new com.degree.backendkotlin.dto.LabelCountDto(T.tag, COUNT(CI.id))
        FROM ClothesItem CI
        INNER JOIN CI.tags T
        GROUP BY T.tag
    """)
    fun findLabelCountGroupedByTag(): List<LabelCountDto>
}