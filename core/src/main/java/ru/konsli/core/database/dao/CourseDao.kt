package ru.konsli.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.konsli.core.database.entity.CourseEntity

@Dao
interface CourseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCourses(courses: List<CourseEntity>)

    @Query("SELECT * FROM Courses")
    fun getCourses(): Flow<List<CourseEntity>>

    @Query("SELECT * FROM Courses WHERE hasLike = 1")
    fun getFavoriteCourses(): Flow<List<CourseEntity>>

    // Запрос для обновление статуса избранного по id курсу
    @Query("UPDATE courses SET hasLike = :isLiked WHERE id = :courseId")
    suspend fun updateFavoriteCourse(
        courseId: Int,
        isLiked: Boolean
    )
}