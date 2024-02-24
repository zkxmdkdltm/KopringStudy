package com.example.banking.domain.account

import com.example.banking.domain.user.User
import com.example.banking.support.BaseTimeEntity
import jakarta.persistence.*

@Entity
class Account(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    val id: Long = 0,
    val balance: Double,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User
) : BaseTimeEntity() {
}