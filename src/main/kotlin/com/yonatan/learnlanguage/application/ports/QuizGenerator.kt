package com.yonatan.learnlanguage.application.ports

import com.yonatan.learnlanguage.domain.entity.Question
import java.util.UUID

fun interface QuizGenerator {
    fun generateQuestions(userId: UUID): List<Question>
}
