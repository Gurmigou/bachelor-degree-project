package com.example.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@SpringBootApplication
class BackEndApplication

fun main(args: Array<String>) {
    runApplication<BackEndApplication>(*args)
}