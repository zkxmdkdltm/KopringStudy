package com.example.banking.domain.transaction

import com.example.banking.support.BaseTimeEntity
import jakarta.persistence.*

@Entity
class Transaction(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    val id: Long = 0,
    val type: TransactionType,
    val amount: Double,
) : BaseTimeEntity() {
}