package com.lyjguy.kotlinspring.service

import com.lyjguy.kotlinspring.model.dto.ReqOrderDto
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
    fun save(reqOrderDto: ReqOrderDto) {
        val order = Order(
            name = reqOrderDto.name,
            status = "ORDER",
            totalPrice = reqOrderDto.totalPrice,
        ).also {
            it.orderReceiver = OrderReceiver(
                name = reqOrderDto.receiver.name,
                address1 = reqOrderDto.receiver.address1,
                address2 = reqOrderDto.receiver.address2,
                zipcode = reqOrderDto.receiver.zipcode,
            )
        }
        orderRepository.save(order).also {
            orderReceiverService.save(it.orderReceiver!!)
        }
    }
}