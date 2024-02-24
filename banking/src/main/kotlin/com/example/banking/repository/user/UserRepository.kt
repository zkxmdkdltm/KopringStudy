package com.example.banking.repository.user

import com.example.banking.domain.user.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findUserByUserInfoName(name: String): MutableList<User>
}