package com.yonatan.lingoquest.adapters.input

import com.yonatan.lingoquest.adapters.input.dto.QuizDto
import com.yonatan.lingoquest.adapters.input.dto.toDto
import com.yonatan.lingoquest.application.usecase.GetQuizUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/quiz")
class GetQuizController(
    private val getQuizUseCase: GetQuizUseCase,
) {
    @GetMapping("/{quizId}")
    fun getQuiz(
        @PathVariable quizId: UUID,
    ): QuizDto {
        val quiz = getQuizUseCase(quizId)
        return quiz.toDto()
    }
}
