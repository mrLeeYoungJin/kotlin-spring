package com.lyjguy.kotlinspring.controller

import com.lyjguy.kotlinspring.model.dto.ReqOrderDto
import com.lyjguy.kotlinspring.model.vo.OrderVO
import com.lyjguy.kotlinspring.service.OrderService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController(
    val orderService: OrderService,
) {

    @GetMapping("/orders/{orderId}")
    fun getOrder(@PathVariable("orderId") orderId : Long): OrderVO {
        return orderService.getOrder(orderId = orderId)
    }

    @PostMapping("/orders")
    fun savePost(@RequestBody reqOrderDto: ReqOrderDto) {
        orderService.save(reqOrderDto)
    }
}