package com.lyjguy.kotlinspring.repository

import com.lyjguy.kotlinspring.model.entity.OrderItem
import org.springframework.data.jpa.repository.JpaRepository

interface OrderItemRepository: JpaRepository<OrderItem, Long> {
}