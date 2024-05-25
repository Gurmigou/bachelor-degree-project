package com.degree.backendkotlin.serivce

import com.degree.backendkotlin.model.User
import com.degree.backendkotlin.repository.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService @Autowired constructor(
    private val userRepository: UserRepo
) {

    fun getUser(userId: Long?): User {
        if (userId == null)
            throw RuntimeException("User id is null")
        return userRepository.findById(userId).orElseThrow {
            RuntimeException("User not found with id: $userId")
        }
    }

}