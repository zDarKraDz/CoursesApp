package ru.konsli.core.network.api

import retrofit2.http.GET
import ru.konsli.core.network.dto.CoursesResponse

interface CoursesApi{
    @GET("courses")
    suspend fun getCourses(): CoursesResponse
}
