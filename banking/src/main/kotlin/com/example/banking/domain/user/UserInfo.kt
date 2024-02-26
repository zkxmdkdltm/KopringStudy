package com.example.banking.domain.user

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded

@Embeddable
data class UserInfo(
    @Column(nullable = false)
    val name: String,

    @Embedded
    var address: Address
) {
    constructor(
        name: String,
        city: String,
        street: String,
        zipcode: String
    ) : this(
        name, Address(city, street, zipcode)
    )

}