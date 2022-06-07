package com.lyjguy.kotlinspring.service

import com.lyjguy.kotlinspring.model.dto.ReqOrderDto
import com.lyjguy.kotlinspring.model.dto.ReqOrderReceiverDto
import org.junit.jupiter.api.Test

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class OrderServiceTest(
    val orderService: OrderService,
) {

    @Test
    fun save() {
        val reqOrderDto = ReqOrderDto(
            name = "test",
            totalPrice = 1000,
            receiver = ReqOrderReceiverDto(
                name = "test",
                address1 = "address1",
                address2 = "address2",
                zipcode = "12345"
            )
        )
        orderService.save(reqOrderDto)
    }
}