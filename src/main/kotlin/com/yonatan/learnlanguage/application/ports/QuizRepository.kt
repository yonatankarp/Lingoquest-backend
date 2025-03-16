package com.yonatan.learnlanguage.application.ports

import com.yonatan.learnlanguage.domain.entity.Quiz
import java.util.UUID

interface QuizRepository {
    fun save(quiz: Quiz): Quiz

    fun findById(id: UUID): Quiz?
}
