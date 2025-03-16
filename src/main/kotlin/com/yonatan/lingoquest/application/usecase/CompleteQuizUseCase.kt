package com.yonatan.lingoquest.application.usecase

import com.yonatan.lingoquest.application.ports.QuizRepository
import com.yonatan.lingoquest.domain.exception.QuizNotFoundException
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
