package com.yonatan.lingoquest.adapters.output.persistence.postgres.mappers

import com.yonatan.lingoquest.adapters.output.persistence.postgres.data.QuizData
import com.yonatan.lingoquest.adapters.output.persistence.postgres.mappers.QuestionMapper.toEntity
import com.yonatan.lingoquest.domain.entity.Quiz
import com.yonatan.lingoquest.domain.valueobject.QuizStatus

object QuizMapper {
    fun Quiz.toEntity(): QuizData =
        QuizData(
            quizId = id,
            status = status.name,
            questions = questions.map { it.toEntity() },
        ).apply {
            questions.forEach { it.quiz = this }
        }

    fun QuizData.toDomain(): Quiz {
        val id = requireNotNull(quizId) { "Quiz ID must not be null" }
        val status = requireNotNull(status) { "Quiz status must not be null" }

        return Quiz(
            id = id,
            status = QuizStatus.valueOf(status),
            questions = questions.map { QuestionMapper.toDomain(it) },
        )
    }
}
