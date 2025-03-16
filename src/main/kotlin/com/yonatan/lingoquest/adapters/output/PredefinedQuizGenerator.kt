package com.yonatan.lingoquest.adapters.output

import com.yonatan.lingoquest.application.ports.QuizGenerator
import com.yonatan.lingoquest.domain.entity.Answer
import com.yonatan.lingoquest.domain.entity.FillInTheBlankQuestion
import com.yonatan.lingoquest.domain.entity.MultipleChoiceQuestion
import com.yonatan.lingoquest.domain.entity.Question
import com.yonatan.lingoquest.domain.entity.SingleAnswerQuestion
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class PredefinedQuizGenerator : QuizGenerator {
    override fun generateQuestions(userId: UUID): List<Question> =
        listOf(
            SingleAnswerQuestion(
                id = UUID.randomUUID(),
                content = "What is 'Hello' in Spanish?",
                options =
                    listOf(
                        Answer(content = "Hola", isCorrect = true),
                        Answer(content = "Bonjour", isCorrect = false),
                    ),
            ),
            MultipleChoiceQuestion(
                id = UUID.randomUUID(),
                content = "Which of the following are programming languages?",
                options =
                    listOf(
                        Answer(content = "Java", isCorrect = true),
                        Answer(content = "Python", isCorrect = true),
                        Answer(content = "Cucumber", isCorrect = false),
                        Answer(content = "Lettuce", isCorrect = false),
                    ),
            ),
            FillInTheBlankQuestion(
                id = UUID.randomUUID(),
                content = "The capital of France is ___.",
                correctAnswer =
                    listOf(
                        Answer(
                            content = "Paris",
                            isCorrect = true,
                        ),
                    ),
            ),
        )
}
