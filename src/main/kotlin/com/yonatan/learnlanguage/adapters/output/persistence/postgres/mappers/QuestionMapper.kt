package com.yonatan.learnlanguage.adapters.output.persistence.postgres.mappers

import com.yonatan.learnlanguage.adapters.output.persistence.postgres.data.QuestionData
import com.yonatan.learnlanguage.adapters.output.persistence.postgres.mappers.AnswerMapper.findAllCorrectAnswers
import com.yonatan.learnlanguage.adapters.output.persistence.postgres.mappers.AnswerMapper.toEntity
import com.yonatan.learnlanguage.domain.entity.FillInTheBlankQuestion
import com.yonatan.learnlanguage.domain.entity.MultipleChoiceQuestion
import com.yonatan.learnlanguage.domain.entity.Question
import com.yonatan.learnlanguage.domain.entity.SingleAnswerQuestion
import com.yonatan.learnlanguage.domain.valueobject.QuestionType

object QuestionMapper {
    fun Question.toEntity(): QuestionData =
        when (this) {
            is SingleAnswerQuestion -> toEntity()
            is MultipleChoiceQuestion -> toEntity()
            is FillInTheBlankQuestion -> toEntity()
        }.also {
            it.assignQuestionToOptions()
        }

    private fun SingleAnswerQuestion.toEntity() =
        QuestionData(
            questionId = id,
            question = content,
            questionType = QuestionType.SINGLE_ANSWER.name,
            options = options.toEntity(),
        )

    private fun MultipleChoiceQuestion.toEntity() =
        QuestionData(
            questionId = id,
            question = content,
            questionType = QuestionType.MULTIPLE_CHOICE.name,
            options = options.toEntity(),
        )

    private fun FillInTheBlankQuestion.toEntity() =
        QuestionData(
            questionId = id,
            question = content,
            questionType = QuestionType.FILL_IN_THE_BLANK.name,
            options = options.toEntity(),
        )

    private fun QuestionData.assignQuestionToOptions() = also { options.forEach { it.question = this } }

    fun toDomain(questionData: QuestionData): Question =
        when (questionData.questionType) {
            "SINGLE_ANSWER" -> questionData.toSingleAnswerQuestion()
            "MULTIPLE_CHOICE" -> questionData.toMultipleChoiceQuestion()
            "FILL_IN_THE_BLANK" -> questionData.toFillInTheBlankQuestion()
            else -> throw IllegalArgumentException("Unknown question type: ${questionData.questionType}")
        }

    private fun QuestionData.toSingleAnswerQuestion() =
        SingleAnswerQuestion(
            id = questionId!!,
            content = question!!,
            options = options.map { AnswerMapper.toDomain(it) },
        )

    private fun QuestionData.toMultipleChoiceQuestion() =
        MultipleChoiceQuestion(
            id = questionId!!,
            content = question!!,
            options = options.map { AnswerMapper.toDomain(it) },
        )

    private fun QuestionData.toFillInTheBlankQuestion() =
        FillInTheBlankQuestion(
            id = questionId!!,
            content = question!!,
            correctAnswer = options.findAllCorrectAnswers(),
        )
}
