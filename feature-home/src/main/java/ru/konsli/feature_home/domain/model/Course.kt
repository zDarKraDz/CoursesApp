package ru.konsli.feature_home.domain.model

import java.time.LocalDate

data class Course(
    val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val rate: Float,
    val startDate: LocalDate,
    val isFavorite: Boolean,
    val publishDate: LocalDate
)