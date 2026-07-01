package ru.konsli.feature_home.domain.usecase

import kotlinx.coroutines.flow.Flow
import ru.konsli.feature_home.domain.model.Course
import ru.konsli.feature_home.domain.repository.CourseRepository
import javax.inject.Inject

class GetFavoriteCoursesUseCase @Inject constructor(
    private val repository: CourseRepository
) {
    operator fun invoke(): Flow<List<Course>> {
        return repository.getFavorites()
    }
}