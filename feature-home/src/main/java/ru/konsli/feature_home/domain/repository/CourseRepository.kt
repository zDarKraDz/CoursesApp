package ru.konsli.feature_home.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.konsli.feature_home.domain.model.Course

interface CourseRepository {

    fun getCourses(): Flow<List<Course>>

    fun getFavorites(): Flow<List<Course>>

    suspend fun updateFavorite(
        courseId: Int,
        isFavorite: Boolean
    )
}