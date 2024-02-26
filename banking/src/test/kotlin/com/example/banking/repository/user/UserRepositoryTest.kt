package com.example.banking.repository.user

import com.example.banking.domain.account.Account
import com.example.banking.domain.user.TestEntity
import com.example.banking.domain.user.User
import com.example.banking.domain.user.UserInfo
import com.example.banking.repository.TestRepository
import com.example.banking.repository.account.AccountRepository
import jakarta.persistence.EntityManager
import jakarta.transaction.Transactional
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback

@SpringBootTest
@Transactional
@Rollback(value = false)
class UserRepositoryTest(
    @Autowired private val userRepository: UserRepository,
    @Autowired private val accountRepository: AccountRepository,
    @Autowired private val testRepository: TestRepository,
    @Autowired private val em: EntityManager
) {

    @Test
    fun testUser() {
        val user = User(UserInfo("b", "Seoul", "123", "123"))

        userRepository.save(user)

//
        em.flush()
        em.clear()

//        val findAll = userRepository.findAll()
//        for (user1 in findAll) {
//            println(user1)
//        }

        val findUser = userRepository.findById(user.id).get()
        println("findUser = ${findUser.name}")

        assertThat(findUser).isEqualTo(user)

    }

    @Test
    fun testAccount() {
        val user = User(UserInfo("b", "Seoul", "123", "123"))
        val account = Account(100.0, user)

        userRepository.save(user)
        accountRepository.save(account)

        em.flush()
        em.clear()

        accountRepository.findAll()

    }

    @Test
    fun testTest() {
        val test = TestEntity("hello")

        testRepository.save(test)

        em.flush()
        em.clear()

        val findById = testRepository.findById(test.id).get()

        assertThat(test).isEqualTo(findById)



        println("findById = ${findById}")

    }
}