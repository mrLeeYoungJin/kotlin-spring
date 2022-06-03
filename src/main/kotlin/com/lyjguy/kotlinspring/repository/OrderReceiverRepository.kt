package com.lyjguy.kotlinspring.repository

import com.lyjguy.kotlinspring.model.entity.OrderReceiver
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface OrderReceiverRepository: JpaRepository<OrderReceiver, Long> {
    fun findByOrderId(id: Long): Optional<OrderReceiver>
}