package com.degree.backendkotlin.repository

import com.degree.backendkotlin.model.OutfitTag
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface OutfitTagRepo : CrudRepository<OutfitTag, Long> {
}