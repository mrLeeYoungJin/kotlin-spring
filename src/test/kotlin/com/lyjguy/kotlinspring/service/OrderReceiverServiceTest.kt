package com.lyjguy.kotlinspring.service

import org.junit.jupiter.api.Test

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class OrderReceiverServiceTest(
    val orderReceiverService: OrderReceiverService
) {

    @Test
    fun save() {
    }

    @Test
    fun findById() {
        val orderReceiver = orderReceiverService.findById(7)

        println("orderReceiver : ${orderReceiver?.id}")
    }

    @Test
    fun findByOrderId() {
    }
}