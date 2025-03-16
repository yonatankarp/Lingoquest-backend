package com.yonatan.lingoquest.application.ports

import com.yonatan.lingoquest.domain.entity.Question
import java.util.UUID

fun interface QuizGenerator {
    fun generateQuestions(userId: UUID): List<Question>
}
