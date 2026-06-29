package ru.konsli.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.konsli.core.database.AppDatabase
import ru.konsli.core.database.dao.CourseDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context : Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "courses_db"
        ).build()

    @Provides
    @Singleton
    fun provideCourseDao( database: AppDatabase): CourseDao =
        database.courseDao()
}