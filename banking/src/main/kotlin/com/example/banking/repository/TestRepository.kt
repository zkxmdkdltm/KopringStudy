package com.example.banking.repository

import com.example.banking.domain.user.TestEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TestRepository : JpaRepository<TestEntity, Long> {
}