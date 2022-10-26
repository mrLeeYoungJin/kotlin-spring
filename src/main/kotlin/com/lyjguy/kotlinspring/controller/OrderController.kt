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

    @GetMapping("/{id}")
    fun getUserOrderList(@RequestParam("userId") userId: Long): List<OrderVO> {
        return orderService.getUserOrderList(userId)
    }

    @PostMapping
    fun savePost(@RequestBody reqOrderDto: ReqOrderDto) {
        orderService.save(reqOrderDto)
    }
}