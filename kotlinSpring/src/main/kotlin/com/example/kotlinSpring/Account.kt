package com.example.kotlinSpring

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.web.bind.annotation.*

@Entity
data class Account(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String
) {

}

data class AccountDto(
    val id: Long,
    val name: String
)

fun Account.toDto() = AccountDto(id, name)

interface AccountRepository : CrudRepository<Account, Long> {
    fun findByNameStartingWith(@Param("name") prefix: String): Iterable<Account>
}

@RestController
@RequestMapping("accounts")
class AccountsController(
    val accountRepository: AccountRepository
) {
    @GetMapping
    fun findAll(): Iterable<AccountDto> = accountRepository.findAll().map { it.toDto() }

    @PostMapping
    fun create(@RequestBody createAccount: CreateAccount): AccountDto =
        accountRepository.save(Account(name = createAccount.name)).toDto()

    @GetMapping("/prefix")
    fun findByName(@RequestParam(value = "name") prefix: String): Iterable<AccountDto> =
        accountRepository.findByNameStartingWith(prefix).map { it.toDto() }
}

data class CreateAccount(
    val name: String
)