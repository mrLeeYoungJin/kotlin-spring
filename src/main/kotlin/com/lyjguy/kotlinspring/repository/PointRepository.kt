package com.lyjguy.kotlinspring.repository

import com.lyjguy.kotlinspring.model.entity.Point
import org.springframework.data.jpa.repository.JpaRepository

interface PointRepository: JpaRepository<Point, Long> {
}