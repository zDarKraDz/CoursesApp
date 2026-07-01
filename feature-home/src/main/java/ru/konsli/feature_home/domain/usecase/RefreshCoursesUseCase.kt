package ru.konsli.feature_home.domain.usecase

import ru.konsli.feature_home.domain.repository.CourseRepository
import javax.inject.Inject

class RefreshCoursesUseCase @Inject constructor(
    private val repository: CourseRepository
) {
    suspend operator fun invoke() {
        repository.refreshCourses()
    }
}