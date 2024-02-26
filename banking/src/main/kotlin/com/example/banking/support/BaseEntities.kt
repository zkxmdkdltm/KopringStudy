package com.example.banking.support

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.domain.AbstractAggregateRoot
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import java.util.*


@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L
) {

    @CreatedDate
    @Column(updatable = false)
    var createdDate: LocalDateTime? = null

    @LastModifiedDate
    var lastModifiedDate: LocalDateTime? = null
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BaseEntity

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}


@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseRootEntity<T : AbstractAggregateRoot<T>>(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L
) : AbstractAggregateRoot<T>() {
    override fun equals(other: Any?): Boolean =
        Objects.equals(id, (other as? BaseRootEntity<T>)?.id)

    override fun hashCode(): Int =
        Objects.hashCode(id)

    @CreatedDate
    @Column(updatable = false)
    var createdDate: LocalDateTime? = LocalDateTime.now()

    @LastModifiedDate
    var lastModifiedDate: LocalDateTime? = LocalDateTime.now()
}
