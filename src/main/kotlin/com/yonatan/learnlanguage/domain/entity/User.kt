package com.yonatan.learnlanguage.domain.entity

import com.yonatan.learnlanguage.domain.valueobject.Language
import java.util.UUID

data class User(
    val id: UUID,
    val username: String,
    val email: String,
    val languagePreferences: List<Language>
)
