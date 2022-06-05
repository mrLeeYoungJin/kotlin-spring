package com.lyjguy.kotlinspring.repository

import com.lyjguy.kotlinspring.model.entity.Coupon
import org.springframework.data.jpa.repository.JpaRepository

interface CouponRepository: JpaRepository<Coupon, Long> {
}