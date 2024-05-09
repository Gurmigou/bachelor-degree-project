package com.degree.backendkotlin.repository

import com.degree.backendkotlin.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepo : CrudRepository<User, Long> {
}