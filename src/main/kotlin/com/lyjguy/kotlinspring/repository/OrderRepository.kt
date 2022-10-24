package com.lyjguy.kotlinspring.repository

import com.lyjguy.kotlinspring.model.entity.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository: JpaRepository<Order, Long> {
    fun findAllByUserId(userId: Long): List<Order>
}