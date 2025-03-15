package com.yonatan.learnlanguage.application.usecase

import com.yonatan.learnlanguage.application.ports.QuizRepository
import com.yonatan.learnlanguage.domain.exception.QuizNotFoundException
import java.util.UUID
import org.springframework.stereotype.Service

@Service
class GetQuizUseCase(
    private val quizRepository: QuizRepository
) {
    operator fun invoke(quizId: UUID) =
        quizRepository.findById(quizId) ?: throw QuizNotFoundException()
}
