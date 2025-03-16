package com.yonatan.lingoquest.adapters.input

import com.yonatan.lingoquest.adapters.input.dto.QuizDto
import com.yonatan.lingoquest.adapters.input.dto.toDto
import com.yonatan.lingoquest.application.usecase.GenerateQuizUseCase
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/quiz")
class GenerateQuizController(
    private val generateQuizUseCase: GenerateQuizUseCase,
) {
    @PostMapping("/generate/{userId}")
    fun generateQuiz(
        @PathVariable userId: UUID,
    ): QuizDto {
        val quiz = generateQuizUseCase(userId)
        return quiz.toDto()
    }
}
