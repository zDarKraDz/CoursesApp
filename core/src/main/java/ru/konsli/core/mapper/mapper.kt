package ru.konsli.core.mapper

import ru.konsli.core.database.entity.CourseEntity
import ru.konsli.core.network.dto.CourseDto
import java.time.LocalDate


// Функция преобразования переменных в нужные типы, для удобства в дальнейшей разработки
fun CourseDto.toEntity(): CourseEntity{

    return CourseEntity(
        id = id,
        title = title,
        text = text,
        price = price.toInt(),
        rate = rate.toFloat(),
        startDate = LocalDate.parse(startDate),
        hasLike = hasLike,
        publishDate = LocalDate.parse(publishDate)
    )
}

