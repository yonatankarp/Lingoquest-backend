package com.yonatan.learnlanguage.application.usecase

import com.yonatan.learnlanguage.application.ports.QuizGenerator
import com.yonatan.learnlanguage.application.ports.QuizRepository
import com.yonatan.learnlanguage.domain.entity.Quiz
import com.yonatan.learnlanguage.domain.valueobject.QuizStatus
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
