package com.lyjguy.kotlinspring.service

import com.lyjguy.kotlinspring.model.entity.User
import com.lyjguy.kotlinspring.repository.UserRepository
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler
import org.springframework.restdocs.operation.preprocess.Preprocessors.*
import org.springframework.restdocs.payload.JsonFieldType
import org.springframework.restdocs.payload.PayloadDocumentation.*
import org.springframework.restdocs.snippet.Attributes
import java.util.*

@AutoConfigureRestDocs
@ExtendWith(MockKExtension::class)
class UserService1Test {
    @RelaxedMockK
    lateinit var userRepository: UserRepository

    @InjectMockKs
    lateinit var userService: UserService

    @Test
    fun findById() {
        val userMock = mockk<User>(relaxed = true) {
            every { id } returns 1
        }
        every { userRepository.findById(any()) } returns Optional.of(userMock)

        val user = userService.findById(1)

        assertThat(user?.id).isEqualTo(1)
    }
}