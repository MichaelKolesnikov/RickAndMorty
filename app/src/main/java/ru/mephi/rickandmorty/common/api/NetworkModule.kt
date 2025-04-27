package ru.mephi.rickandmorty.common.api

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

object NetworkModule {
    val publicClient = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json()
        }
    }
}