package com.example.banking.repository.transaction

import com.example.banking.domain.transaction.Transaction
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionRepository : JpaRepository<Transaction, Long> {
}