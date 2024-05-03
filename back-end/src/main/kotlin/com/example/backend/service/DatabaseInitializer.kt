//package com.example.backend.service
//
//import jakarta.annotation.PostConstruct
//import org.springframework.data.mongodb.core.MongoTemplate
//import org.springframework.stereotype.Component
//
//@Component
//class DatabaseInitializer(private val mongoTemplate: MongoTemplate) {
//
//    @PostConstruct
//    fun init() {
//        println("works init for database")
//        if (!mongoTemplate.collectionExists("clothesItems")) {
//            mongoTemplate.createCollection("clothesItems")
//        }
//    }
//}