package com.yonatan.lingoquest.application.ports

import com.yonatan.lingoquest.domain.entity.Quiz
import java.util.UUID

interface QuizRepository {
    fun save(quiz: Quiz): Quiz

    fun findById(id: UUID): Quiz?
}
