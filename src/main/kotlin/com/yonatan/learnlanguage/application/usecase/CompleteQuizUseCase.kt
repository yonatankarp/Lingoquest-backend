package com.yonatan.learnlanguage.application.usecase

import com.yonatan.learnlanguage.application.ports.QuizRepository
import com.yonatan.learnlanguage.domain.exception.QuizNotFoundException
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CompleteQuizUseCase(
    private val quizRepository: QuizRepository,
) {
    // TODO: mark per user that the quiz is completed
    operator fun invoke(quizId: UUID) {
        val quiz = quizRepository.findById(quizId) ?: throw QuizNotFoundException()
        quizRepository.save(quiz.completeQuiz())
    }
}
