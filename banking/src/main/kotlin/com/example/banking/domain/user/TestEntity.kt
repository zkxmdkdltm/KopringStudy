package com.example.banking.domain.user

import com.example.banking.support.BaseEntity
import jakarta.persistence.Entity

@Entity
class TestEntity(
    val name: String,

    id: Long = 0L
) : BaseEntity(id) {

}