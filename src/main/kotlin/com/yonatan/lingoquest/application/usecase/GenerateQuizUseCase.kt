package com.yonatan.lingoquest.application.usecase

import com.yonatan.lingoquest.application.ports.QuizGenerator
import com.yonatan.lingoquest.application.ports.QuizRepository
import com.yonatan.lingoquest.domain.entity.Quiz
import com.yonatan.lingoquest.domain.valueobject.QuizStatus
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class GenerateQuizUseCase(
    private val quizRepository: QuizRepository,
    private val quizGenerator: QuizGenerator,
) {
    operator fun invoke(userId: UUID): Quiz {
        val questions = quizGenerator.generateQuestions(userId)

        val quiz =
            Quiz(
                id = UUID.randomUUID(),
                questions = questions,
                status = QuizStatus.OPEN,
            )

        return quizRepository.save(quiz)
    }
}
