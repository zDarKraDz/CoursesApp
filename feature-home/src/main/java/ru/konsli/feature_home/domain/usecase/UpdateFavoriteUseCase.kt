package ru.konsli.feature_home.domain.usecase

import ru.konsli.feature_home.domain.repository.CourseRepository
import javax.inject.Inject

class UpdateFavoriteUseCase @Inject constructor(
    private val repository: CourseRepository

){
    suspend operator fun invoke(
        courseId: Int,
        isFavorite: Boolean
    ){
        repository.updateFavorite(courseId, isFavorite)
    }
}