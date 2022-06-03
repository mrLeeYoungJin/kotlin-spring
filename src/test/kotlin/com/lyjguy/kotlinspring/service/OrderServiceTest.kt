package com.lyjguy.kotlinspring.service

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class OrderServiceTest(
    val orderService: OrderService,
) {

    @Test
    fun save() {
        orderService.save()
    }
}