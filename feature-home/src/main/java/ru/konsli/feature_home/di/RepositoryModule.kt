package ru.konsli.feature_home.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.konsli.feature_home.data.repository.CourseRepositoryImpl
import ru.konsli.feature_home.domain.repository.CourseRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    // При запросе CourseRepository выдать CourseRepositoryImpl
    @Binds
    @Singleton
    abstract fun bindCourseRepository(
        repositoryImpl: CourseRepositoryImpl
    ): CourseRepository
}