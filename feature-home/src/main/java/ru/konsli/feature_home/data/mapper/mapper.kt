package ru.konsli.feature_home.data.mapper

import ru.konsli.core.database.entity.CourseEntity
import ru.konsli.feature_home.domain.model.Course

fun CourseEntity.toDomain(): Course {

    return Course(
        id = id,
        title = title,
        description = text,
        price = price,
        rate = rate,
        startDate = startDate,
        isFavorite = hasLike,
        publishDate = publishDate
    )
}

// В случае изменения статуса isFavorite (hasLike)
fun Course.toEntity(): CourseEntity{

    return CourseEntity(
        id = id,
        title = title,
        text = description,
        price = price,
        rate = rate,
        startDate = startDate,
        hasLike = isFavorite,
        publishDate = publishDate
    )
}