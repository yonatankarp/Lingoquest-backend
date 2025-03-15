package com.yonatan.learnlanguage.adapters.input

import com.yonatan.learnlanguage.adapters.input.dto.QuizDto
import com.yonatan.learnlanguage.adapters.input.dto.toDto
import com.yonatan.learnlanguage.application.usecase.GenerateQuizUseCase
import java.util.UUID
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/quiz")
class GenerateQuizController(
    private val generateQuizUseCase: GenerateQuizUseCase
) {

    @PostMapping("/generate/{userId}")
    fun generateQuiz(@PathVariable userId: UUID): QuizDto {
        val quiz = generateQuizUseCase(userId)
        return quiz.toDto()
    }
}
