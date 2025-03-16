package com.yonatan.learnlanguage.adapters.output.persistence.postgres.data

import jakarta.persistence.CollectionTable
import jakarta.persistence.Column
import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "users")
data class UserData(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,
    @Column(nullable = false, unique = true)
    var userId: UUID? = null,
    var username: String? = null,
    var email: String? = null,
    @ElementCollection
    @CollectionTable(
        name = "user_languages",
        joinColumns = [JoinColumn(name = "user_id")],
    )
    @Column(name = "language")
    var languages: List<String> = emptyList(),
)
