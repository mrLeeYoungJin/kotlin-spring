package com.lyjguy.kotlinspring.repository

import com.lyjguy.kotlinspring.model.entity.OrderReceiver
import org.springframework.data.jpa.repository.JpaRepository

interface OrderReceiverRepository: JpaRepository<OrderReceiver, Long> {
}