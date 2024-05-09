package com.degree.backendkotlin.model

enum class Rate {
    STAR_0,
    STAR_1,
    STAR_2,
    STAR_3,
    STAR_4,
    STAR_5;

    companion object {
        fun getByLongStart(longValue: Long): Rate {
            return when (longValue) {
                0L -> STAR_0
                1L -> STAR_1
                2L -> STAR_2
                3L -> STAR_3
                4L -> STAR_4
                5L -> STAR_5
                else -> throw RuntimeException("Rate not found with value: $longValue")
            }
        }
    }
}