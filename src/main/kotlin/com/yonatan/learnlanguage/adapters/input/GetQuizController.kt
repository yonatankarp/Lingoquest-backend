package com.yonatan.learnlanguage.adapters.input

import com.yonatan.learnlanguage.adapters.input.dto.QuizDto
import com.yonatan.learnlanguage.adapters.input.dto.toDto
import com.yonatan.learnlanguage.application.usecase.GetQuizUseCase
import java.util.UUID
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/quiz")
class GetQuizController(
    private val getQuizUseCase: GetQuizUseCase
) {

    @GetMapping("/{quizId}")
    fun getQuiz(@PathVariable quizId: UUID): QuizDto {
        val quiz = getQuizUseCase(quizId)
        return quiz.toDto()
    }
}
