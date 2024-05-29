package com.degree.backendkotlin.model

import com.fasterxml.jackson.annotation.JsonValue

enum class Rate(val value: Long) {
    STAR_0(0),
    STAR_1(1),
    STAR_2(2),
    STAR_3(3),
    STAR_4(4),
    STAR_5(5);

    companion object {
        fun getByLongStart(longValue: Long): Rate {
            return when (longValue) {
                0L -> STAR_0
                1L -> STAR_1
                2L -> STAR_2
                3L -> STAR_3
                4L -> STAR_4
                5L, 6L -> STAR_5
                else -> throw RuntimeException("Rate not found with value: $longValue")
            }
        }
    }

    @JsonValue
    fun toValue(): Long {
        return value
    }
}