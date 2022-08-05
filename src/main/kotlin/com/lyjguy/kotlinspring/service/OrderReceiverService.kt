package com.lyjguy.kotlinspring.service

import com.lyjguy.kotlinspring.model.entity.OrderReceiver
import com.lyjguy.kotlinspring.repository.OrderReceiverRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Service
class OrderReceiverService(
    private val orderReceiverRepository: OrderReceiverRepository,
) {

    @Transactional
    fun save(orderReceiver: OrderReceiver) {
        //println("orderReceiver111 : ${orderReceiver.orderId}")
        orderReceiverRepository.save(orderReceiver)
    }

    @Transactional
    fun findById(id: Long): OrderReceiver? {
        return orderReceiverRepository.findByIdOrNull(id)
    }

    @Transactional
    fun findByOrderId(orderId: Long) {
//        println("orderId : ${orderId}")
//        val orderReceiver = orderReceiverRepository.findByOrderId(orderId)
//        println(orderReceiver?.id)
        //println(orderReceiver?.order?.id)
    }
}