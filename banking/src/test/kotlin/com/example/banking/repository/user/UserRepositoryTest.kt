package com.example.banking.repository.user

import com.example.banking.domain.user.User
import com.example.banking.domain.user.UserInfo
import jakarta.persistence.EntityManager
import jakarta.transaction.Transactional
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@Transactional
class UserRepositoryTest(
    @Autowired private val userRepository: UserRepository,
    @Autowired private val em: EntityManager
) {

    @Test
    fun testUser() {
        val user = User(UserInfo("b", "Seoul", "123", "123"))

        userRepository.save(user)


        val findAll = userRepository.findAll()
        for (user1 in findAll) {
            println(user1)
        }
        val findUser = userRepository.findById(user.id).get()
        
        Assertions.assertThat(findUser).isEqualTo(user)

    }
}