package com.lyjguy.kotlinspring.service

import com.lyjguy.kotlinspring.repository.CouponRepository
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class CouponServiceTest {
    @MockK
    lateinit var couponRepository: CouponRepository

    @InjectMockKs
    lateinit var couponService: CouponService

    @Test
    fun save() {
        couponService.save()
    }
}