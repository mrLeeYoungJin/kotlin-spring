package com.lyjguy.kotlinspring.service

import com.lyjguy.kotlinspring.model.entity.Coupon
import com.lyjguy.kotlinspring.model.entity.OrderReceiver
import com.lyjguy.kotlinspring.repository.CouponRepository
import com.lyjguy.kotlinspring.repository.OrderReceiverRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class CouponService(
    private val couponRepository: CouponRepository
) {

    @Transactional
    fun save() {
        val coupon = Coupon(
            userId = 1,
            name = "test",
            code = "code1",
            discountAmount = 1000,
            expirationDate = LocalDateTime.now().plusDays(10)
        )

        couponRepository.save(coupon)
    }
}