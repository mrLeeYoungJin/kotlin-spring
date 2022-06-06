package com.lyjguy.kotlinspring.model.dto

data class ReqOrderDto(
    val name: String,
    val quantity: Int,
    val totalPrice: Int,
    val receiver: ReqOrderReceiverDto
)

data class ReqOrderReceiverDto(
    val name: String,
    val address1: String,
    val address2: String,
    val zipcode: String,
)