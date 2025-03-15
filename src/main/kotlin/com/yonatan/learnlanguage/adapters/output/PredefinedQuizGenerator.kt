package com.yonatan.learnlanguage.adapters.output

import com.yonatan.learnlanguage.application.ports.QuizGenerator
import com.yonatan.learnlanguage.domain.entity.FillInTheBlankQuestion
import com.yonatan.learnlanguage.domain.entity.MultipleChoiceQuestion
import com.yonatan.learnlanguage.domain.entity.Question
import com.yonatan.learnlanguage.domain.entity.SingleAnswerQuestion
import java.util.UUID
import org.springframework.stereotype.Component

@Component
class PredefinedQuizGenerator : QuizGenerator {
    override fun generateQuestions(userId: UUID): List<Question> {
        return listOf(
            SingleAnswerQuestion(
                id = UUID.randomUUID(),
                content = "What is 'Hello' in Spanish?",
                options = listOf("Hola", "Bonjour"),
                correctAnswer = "Hola"
            ),
            MultipleChoiceQuestion(
                id = UUID.randomUUID(),
                content = "Which of the following are programming languages?",
                options = listOf("Java", "Python", "Cucumber", "Lettuce"),
                correctAnswers = listOf("Java", "Python")
            ),
            FillInTheBlankQuestion(
                id = UUID.randomUUID(),
                content = "The capital of France is ___.",
                correctAnswer = "Paris"
            )
        )
    }
}
