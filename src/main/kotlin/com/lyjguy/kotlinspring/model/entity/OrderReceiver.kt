package com.lyjguy.kotlinspring.model.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name="order_receivers")
class OrderReceiver(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val orderId: Long,
    var name: String,
    var address1: String,
    var address2: String,
    var zipcode: String,
    val createAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime? = null,

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId", insertable = false, updatable = false, nullable = false)
    @JsonBackReference
    var order: Order
)