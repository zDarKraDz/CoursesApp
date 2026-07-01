package ru.konsli.feature_home.presentation

import ru.konsli.feature_home.domain.model.Course

// Состояния экрана, при которых будет происходить рекомпозиция
data class HomeState(
    val courses: List<Course> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)