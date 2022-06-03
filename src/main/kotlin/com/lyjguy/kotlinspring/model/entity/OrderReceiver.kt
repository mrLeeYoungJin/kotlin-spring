package com.lyjguy.kotlinspring.model.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.lyjguy.kotlinspring.model.entity.Order
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name="order_receivers")
class OrderReceiver(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    var orderId: Long = 0,
    var name: String,
    val address1: String,
    val address2: String,
    val zipcode: String,
    val createAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime? = null,
) {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    @JsonBackReference
    lateinit var order: Order
}