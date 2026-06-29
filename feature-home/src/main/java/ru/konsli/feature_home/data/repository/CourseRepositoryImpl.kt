package ru.konsli.feature_home.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.konsli.core.database.dao.CourseDao
import ru.konsli.feature_home.data.mapper.toDomain
import ru.konsli.feature_home.domain.model.Course
import ru.konsli.feature_home.domain.repository.CourseRepository
import javax.inject.Inject

class CourseRepositoryImpl @Inject constructor(
    private val dao: CourseDao
) : CourseRepository {

    override fun getCourses(): Flow<List<Course>> =
        dao.getCourses().map { list ->
            list.map { it.toDomain() }
        }

    override fun getFavorites(): Flow<List<Course>> =
        dao.getFavoriteCourses().map { list ->
            list.map { it.toDomain() }
        }

    override suspend fun updateFavorite(
        courseId: Int,
        isFavorite: Boolean
    ) {
        dao.updateFavoriteCourse(courseId, isFavorite)
    }
}