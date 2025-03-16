package com.yonatan.lingoquest.domain.entity

import java.util.UUID

sealed class Question(
    open val id: UUID,
    open val content: String,
    open val options: List<Answer>,
)

data class SingleAnswerQuestion(
    override val id: UUID,
    override val content: String,
    override val options: List<Answer>,
) : Question(id, content, options)

data class MultipleChoiceQuestion(
    override val id: UUID,
    override val content: String,
    override val options: List<Answer>,
) : Question(id, content, options)

data class FillInTheBlankQuestion(
    override val id: UUID,
    override val content: String,
    val correctAnswer: List<Answer>,
) : Question(id, content, emptyList())
