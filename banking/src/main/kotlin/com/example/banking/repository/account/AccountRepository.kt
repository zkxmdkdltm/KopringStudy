package com.example.banking.repository.account

import com.example.banking.domain.account.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Account, Long> {
}