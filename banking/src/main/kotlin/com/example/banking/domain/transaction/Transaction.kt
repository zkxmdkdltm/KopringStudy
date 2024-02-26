package com.example.banking.domain.transaction

import com.example.banking.support.BaseEntity
import jakarta.persistence.Entity

@Entity
class Transaction(
    val type: TransactionType,
    val amount: Double,
    id: Long = 0
) : BaseEntity(id) {
}