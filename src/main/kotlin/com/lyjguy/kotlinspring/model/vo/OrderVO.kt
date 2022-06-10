package com.lyjguy.kotlinspring.model.vo

import com.lyjguy.kotlinspring.model.entity.Order
import java.time.LocalDateTime

data class OrderVO(
    val id: Long = 0,
    val userId: Long = 0,
    val name: String = "",
    val status: String = "",
    val totalPrice: Int = 0,
    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null,
)

fun Order.toOrderVO(): OrderVO {
    return OrderVO(
        id, userId, name, status, totalPrice, createdAt, updatedAt
    )
}