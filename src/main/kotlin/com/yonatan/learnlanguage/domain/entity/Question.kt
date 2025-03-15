package com.yonatan.learnlanguage.domain.entity

import java.util.UUID

sealed class Question(
    open val id: UUID,
    open val content: String
) {
    abstract fun isCorrect(): Boolean
}

data class SingleAnswerQuestion(
    override val id: UUID,
    override val content: String,
    val options: List<String>,
    val correctAnswer: String,
    val selectedAnswer: String? = null,
) : Question(id, content) {
    override fun isCorrect() = selectedAnswer == correctAnswer
}

data class MultipleChoiceQuestion(
    override val id: UUID,
    override val content: String,
    val options: List<String>,
    val correctAnswers: List<String>,
    var selectedAnswers: List<String> = emptyList()
) : Question(id, content) {
    override fun isCorrect() = selectedAnswers.sorted() == correctAnswers.sorted()
}

data class FillInTheBlankQuestion(
    override val id: UUID,
    override val content: String,
    val correctAnswer: String,
    var userAnswer: String? = null,
) : Question(id, content) {
    override fun isCorrect(): Boolean =
        userAnswer?.trim()?.equals(correctAnswer.trim(), ignoreCase = true) ?: false
}
