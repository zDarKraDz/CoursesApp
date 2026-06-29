package ru.konsli.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.konsli.core.database.dao.CourseDao
import ru.konsli.core.database.entity.CourseEntity

@Database(
    entities = [
        CourseEntity::class
    ],
    version = 1,
)

abstract class AppDatabase: RoomDatabase(){
    abstract fun courseDao(): CourseDao
}