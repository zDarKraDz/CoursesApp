package ru.konsli.core.network.interceptor

import okhttp3.logging.HttpLoggingInterceptor

object LoggingInterceptorProvider {
    fun create(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
}
