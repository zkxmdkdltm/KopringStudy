package com.example.banking.domain.account

import com.example.banking.domain.user.User
import com.example.banking.support.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class Account(
    val balance: Double,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User,
    id: Long = 0


) : BaseEntity(id) {
}