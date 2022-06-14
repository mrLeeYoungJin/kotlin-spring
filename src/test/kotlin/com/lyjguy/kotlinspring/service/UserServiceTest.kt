package com.lyjguy.kotlinspring.service

import org.junit.jupiter.api.Test

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class UserServiceTest(
    val userService: UserService
) {

    @Test
    fun save() {
        userService.save()
    }
}