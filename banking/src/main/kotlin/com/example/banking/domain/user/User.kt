package com.example.banking.domain.user

import com.example.banking.domain.account.Account
import com.example.banking.support.BaseRootEntity
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.OneToMany

@Entity
class User(
    @Embedded
    val userInfo: UserInfo,

    @OneToMany(mappedBy = "user")
    val accounts: MutableList<Account> = mutableListOf(),

    id: Long = 0L

) : BaseRootEntity<User>(id) {
    val name: String
        get() = userInfo.name
    val city: String
        get() = userInfo.address.city
    val street: String
        get() = userInfo.address.street
    val zipcode: String
        get() = userInfo.address.zipcode

    constructor(
        name: String,
        city: String,
        street: String,
        zipcode: String,
        accounts: MutableList<Account>,
        id: Long = 0L,
    ) : this(
        UserInfo(name, Address(city, street, zipcode)), accounts, id
    )


}