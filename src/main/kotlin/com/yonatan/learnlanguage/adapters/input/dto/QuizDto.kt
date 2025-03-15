package com.yonatan.learnlanguage.adapters.input.dto

import com.yonatan.learnlanguage.domain.entity.FillInTheBlankQuestion
import com.yonatan.learnlanguage.domain.entity.MultipleChoiceQuestion
import com.yonatan.learnlanguage.domain.entity.Question
import com.yonatan.learnlanguage.domain.entity.Quiz
import com.yonatan.learnlanguage.domain.entity.SingleAnswerQuestion

data class QuizDto(
    val id: String,
    val status: String,
    val questions: List<QuestionDto>
)

data class QuestionDto(
    val id: String,
    val content: String,
    val options: List<String>?,
    val correctAnswer: String?
)

fun Quiz.toDto(): QuizDto {
    return QuizDto(
        id = this.id.toString(),
        status = this.status.name,
        questions = this.questions.map { it.toDto() }
    )
}

private fun Question.toDto(): QuestionDto {
    return when (this) {
        is SingleAnswerQuestion -> toDto()
        is MultipleChoiceQuestion -> toDto()
        is FillInTheBlankQuestion -> toDto()
    }
}

private fun SingleAnswerQuestion.toDto(): QuestionDto {
    return QuestionDto(
        id = this.id.toString(),
        content = this.content,
        options = this.options,
        correctAnswer = this.correctAnswer
    )
}

private fun MultipleChoiceQuestion.toDto(): QuestionDto {
    return QuestionDto(
        id = this.id.toString(),
        content = this.content,
        options = this.options,
        correctAnswer = this.correctAnswers.joinToString(", ")
    )
}

private fun FillInTheBlankQuestion.toDto(): QuestionDto {
    return QuestionDto(
        id = this.id.toString(),
        content = this.content,
        options = null,
        correctAnswer = this.correctAnswer
    )
}
