package com.example.banking.domain.user

import com.example.banking.domain.account.Account
import com.example.banking.support.BaseTimeEntity
import jakarta.persistence.*

@Entity
class User(
    @Embedded
    val userInfo: UserInfo,

    @OneToMany(mappedBy = "user")
    val accounts: MutableList<Account> = mutableListOf()

) : BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    val id: Long = 0
    override fun toString(): String {
        return "User(userInfo=$userInfo, id=$id)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (userInfo != other.userInfo) return false
        if (accounts != other.accounts) return false
        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        var result = userInfo.hashCode()
        result = 31 * result + accounts.hashCode()
        result = 31 * result + id.hashCode()
        return result
    }


}