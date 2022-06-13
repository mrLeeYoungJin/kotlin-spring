package com.lyjguy.kotlinspring.service

import com.lyjguy.kotlinspring.model.entity.User
import com.lyjguy.kotlinspring.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository,
) {

    @Transactional
    fun save() {
        val user = User(
            name = "test",
            email = "test@test.com",
            password = "1234",
        )

        userRepository.save(user)
    }
}