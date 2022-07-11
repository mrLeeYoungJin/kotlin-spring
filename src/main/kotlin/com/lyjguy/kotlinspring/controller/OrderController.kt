package com.lyjguy.kotlinspring.controller

import com.lyjguy.kotlinspring.model.dto.ReqOrderDto
import com.lyjguy.kotlinspring.model.vo.OrderVO
import com.lyjguy.kotlinspring.service.OrderService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/orders")
class OrderController(
    val orderService: OrderService,
) {

    @GetMapping("/{id}")
    fun getOrder(@PathVariable("id") orderId : Long): OrderVO {
        return orderService.getOrder(orderId = orderId)
    }

    @PostMapping
    fun savePost(@RequestBody reqOrderDto: ReqOrderDto) {
        orderService.save(reqOrderDto)
    }
}