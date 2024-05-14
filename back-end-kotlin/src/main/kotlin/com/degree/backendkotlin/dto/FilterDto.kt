package com.degree.backendkotlin.dto

data class FilterDto(
    val brands: Set<String>,
    val tags: Set<String>
)
