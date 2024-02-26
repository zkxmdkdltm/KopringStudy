package com.example.banking.domain.user

import jakarta.persistence.Embeddable

@Embeddable
class Address(
    val city: String,
    val street: String,
    val zipcode: String
) {
}