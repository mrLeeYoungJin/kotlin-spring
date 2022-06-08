package com.lyjguy.kotlinspring.service

import com.lyjguy.kotlinspring.model.entity.Point
import com.lyjguy.kotlinspring.repository.PointRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

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