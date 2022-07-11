package com.lyjguy.kotlinspring.controller

import com.lyjguy.kotlinspring.model.entity.User
import com.lyjguy.kotlinspring.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/users")
class UserController(
    private val userService: UserService,
) {

    @PostMapping
    fun createUser(): ResponseEntity<Unit> {
        return ResponseEntity.ok(userService.save())
    }

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): ResponseEntity<User?> {
        return ResponseEntity.ok(userService.findById(id))
    }
}