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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UserInfo

        if (name != other.name) return false
        if (address != other.address) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + address.hashCode()
        return result
    }
}