package com.yonatan.lingoquest.application.usecase

import com.yonatan.lingoquest.application.ports.QuizRepository
import com.yonatan.lingoquest.domain.exception.QuizNotFoundException
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class GetQuizUseCase(
    private val quizRepository: QuizRepository,
) {
    operator fun invoke(quizId: UUID) = quizRepository.findById(quizId) ?: throw QuizNotFoundException()
}
