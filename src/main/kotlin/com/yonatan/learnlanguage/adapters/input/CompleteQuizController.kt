package com.yonatan.learnlanguage.adapters.input

import com.yonatan.learnlanguage.application.usecase.CompleteQuizUseCase
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/quiz")
class CompleteQuizController(
    private val completeQuizUseCase: CompleteQuizUseCase,
) {
    @PostMapping("/{quizId}/complete")
    fun completeQuiz(
        @PathVariable quizId: UUID,
    ) {
        completeQuizUseCase(quizId)
    }
}
