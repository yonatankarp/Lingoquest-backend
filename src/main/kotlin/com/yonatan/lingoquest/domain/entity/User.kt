package com.yonatan.lingoquest.domain.entity

import com.yonatan.lingoquest.domain.valueobject.Language
import java.util.UUID

data class User(
    val id: UUID,
    val username: String,
    val email: String,
    val languagePreferences: List<Language>,
)
