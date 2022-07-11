package com.lyjguy.kotlinspring.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.lyjguy.kotlinspring.model.entity.User
import com.lyjguy.kotlinspring.service.UserService
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders
import org.springframework.restdocs.operation.preprocess.Preprocessors.*
import org.springframework.restdocs.payload.JsonFieldType
import org.springframework.restdocs.payload.PayloadDocumentation.*
import org.springframework.restdocs.request.RequestDocumentation.*
import org.springframework.test.context.TestConstructor
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.web.servlet.function.RequestPredicates

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs(uriScheme = "http", uriHost = "localhost")
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class UserControllerTest(
    private val mockMvc: MockMvc,
    private val objectMapper: ObjectMapper,
    private val userService: UserService,
) {

    private val context = "/api/v1/users"

    @Test
    fun getUser() {
        userService.save()
        val id = 1L
        val user = userService.findById(id)
        val userJson = objectMapper.writeValueAsString(user)

        mockMvc.perform(
            RestDocumentationRequestBuilders.get("$context/{id}", 1L)
        ).andDo(
            document(
                "getUser",
                preprocessRequest(
                    modifyUris()
                        .scheme("http")
                        .host("localhost")
                        .port(8080),
                    prettyPrint()),
                preprocessResponse(prettyPrint()),
                pathParameters(
                    parameterWithName("id").description("id")
                ),
                relaxedResponseFields(
                    fieldWithPath("name").type(JsonFieldType.STRING).description("이름"),
                )
            )
        )
//        mockMvc.get("$context/$id")
//            .andDo { print() }
//            .andExpect {
//                status { isOk() }
//                content { RequestPredicates.contentType(MediaType.APPLICATION_JSON) }
//                content { json(userJson) }
//            }
    }
}