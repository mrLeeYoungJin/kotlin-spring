package com.lyjguy.kotlinspring.service

import com.lyjguy.kotlinspring.model.entity.Order
import com.lyjguy.kotlinspring.model.entity.OrderReceiver
import com.lyjguy.kotlinspring.model.vo.OrderVO
import com.lyjguy.kotlinspring.model.vo.toOrderVO
import com.lyjguy.kotlinspring.repository.OrderRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val orderReceiverService: OrderReceiverService,
) {

    @Transactional
    fun getOrder(orderId: Long): OrderVO {
        val order = orderRepository.findById(orderId)
        if (!order.isPresent) {
            return OrderVO()
        }
        return order.get().toOrderVO()
    }

    @Transactional
    fun save() {
        val order = Order(
            name = "test",
            status = "ORDER",
            quantity = 1,
            totalPrice = 1000,
        ).also {
            it.orderReceiver = OrderReceiver(
                name = "test",
                address1 = "address1",
                address2 = "address2",
                zipcode = "12345",
            )
        }
        orderRepository.save(order).also {
            orderReceiverService.save(it.orderReceiver!!)
        }
    }
}