package com.lyjguy.kotlinspring.repository

import com.lyjguy.kotlinspring.model.entity.Order
import com.lyjguy.kotlinspring.model.entity.OrderReceiver
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.TestConstructor
import org.springframework.transaction.annotation.Transactional
import java.util.*

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class OrderRepositoryTest(
    val orderRepository: OrderRepository,
    val orderReceiverRepository: OrderReceiverRepository,
) {

    @DisplayName("jpa one to one persist test")
    @Test
    @Rollback(false)
    @Transactional
    fun save() {
        val order = Order(
            userId = 1,
            name = "test",
            status = "ORDER",
            totalPrice = 1000,
        )

        orderRepository.save(order).also {
            val orderReceiver = OrderReceiver(
                orderId = it.id,
                name = "test",
                address1 = "address1",
                address2 = "address2",
                zipcode = "12345",
                order = it,
            )
            val savedOrderReceiver = orderReceiverRepository.save(orderReceiver)
            order.orderReceiver = orderReceiver
        }
    }

    @Test
    @Rollback(false)
    @Transactional
    fun saveAndUpdate() {
        val orders = orderRepository.findAllById(listOf(6,7)).map {
            it.name = "test_${UUID.randomUUID()}"
            it
        }

        val newOrder = Order(
            userId = 1,
            name = "test_${UUID.randomUUID()}",
            status = "ORDER",
            totalPrice = 1000,
        )

        val saveAndUpdateOrder = orders.plus(newOrder)
        saveAndUpdateOrder.forEach {
            println("it.name : ${it.name}")
        }
        orderRepository.saveAll(saveAndUpdateOrder)
    }
}