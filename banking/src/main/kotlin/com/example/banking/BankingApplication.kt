package com.example.banking

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.domain.AuditorAware
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import java.util.*

@SpringBootApplication
@EnableJpaAuditing
class BankingApplication

fun main(args: Array<String>) {
    runApplication<BankingApplication>(*args)
}

@Bean
fun auditorProvider() = AuditorAware<String> { Optional.of(UUID.randomUUID().toString()) }




