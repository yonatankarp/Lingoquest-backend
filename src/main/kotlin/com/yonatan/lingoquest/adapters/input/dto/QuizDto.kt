package com.yonatan.lingoquest.adapters.input.dto

import com.yonatan.lingoquest.domain.entity.FillInTheBlankQuestion
import com.yonatan.lingoquest.domain.entity.MultipleChoiceQuestion
import com.yonatan.lingoquest.domain.entity.Question
import com.yonatan.lingoquest.domain.entity.Quiz
import com.yonatan.lingoquest.domain.entity.SingleAnswerQuestion

// TODO: refactor all of this...

data class QuizDto(
    val id: String,
    val status: String,
    val questions: List<QuestionDto>,
)

data class QuestionDto(
    val id: String,
    val content: String,
    val options: List<String>?,
    val correctAnswer: String?,
)

fun Quiz.toDto(): QuizDto =
    QuizDto(
        id = this.id.toString(),
        status = this.status.name,
        questions = this.questions.map { it.toDto() },
    )

private fun Question.toDto(): QuestionDto =
    when (this) {
        is SingleAnswerQuestion -> toDto()
        is MultipleChoiceQuestion -> toDto()
        is FillInTheBlankQuestion -> toDto()
    }

private fun SingleAnswerQuestion.toDto(): QuestionDto =
    QuestionDto(
        id = this.id.toString(),
        content = this.content,
        options = this.options.map { it.content },
        correctAnswer = this.options.first { it.isCorrect }.content,
    )

private fun MultipleChoiceQuestion.toDto(): QuestionDto =
    QuestionDto(
        id = this.id.toString(),
        content = this.content,
        options = this.options.map { it.content },
        correctAnswer =
            this.options
                .filter { it.isCorrect }
                .map { it.content }
                .joinToString { ", " },
    )

private fun FillInTheBlankQuestion.toDto(): QuestionDto =
    QuestionDto(
        id = this.id.toString(),
        content = this.content,
        options = null,
        correctAnswer = this.correctAnswer.joinToString(", "),
    )
