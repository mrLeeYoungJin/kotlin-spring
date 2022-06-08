package com.lyjguy.kotlinspring.service

import com.lyjguy.kotlinspring.model.entity.Coupon
import com.lyjguy.kotlinspring.model.entity.OrderReceiver
import com.lyjguy.kotlinspring.model.entity.Point
import com.lyjguy.kotlinspring.repository.CouponRepository
import com.lyjguy.kotlinspring.repository.OrderReceiverRepository
import com.lyjguy.kotlinspring.repository.PointRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class PointService(
    private val pointRepository: PointRepository
) {

    @Transactional
    fun save() {
        val point = Point(
            userId = 1,
            point = 1000,
        )

        pointRepository.save(point)
    }
}