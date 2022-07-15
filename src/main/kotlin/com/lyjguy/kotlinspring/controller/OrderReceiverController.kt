package com.lyjguy.kotlinspring.controller

import com.lyjguy.kotlinspring.service.OrderReceiverService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/order_receivers")
class OrderReceiverController(
    val orderReceiverService: OrderReceiverService
) {

    @GetMapping("/{id}")
    fun getOrderReceiver(@PathVariable("id") id : Long): Long? {
        return orderReceiverService.findById(id)?.id
    }
}