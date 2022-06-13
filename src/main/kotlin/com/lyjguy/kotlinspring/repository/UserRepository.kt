package com.lyjguy.kotlinspring.repository

import com.lyjguy.kotlinspring.model.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
}