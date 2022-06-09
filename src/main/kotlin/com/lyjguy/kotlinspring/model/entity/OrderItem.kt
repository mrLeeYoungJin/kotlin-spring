package com.lyjguy.kotlinspring.model.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name="order_items")
class OrderItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val orderId: Long,
    val userId: Long,
    val productName: String,
    val quantity: Int,
    val price: Int,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime?,
)