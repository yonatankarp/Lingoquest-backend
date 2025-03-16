package com.yonatan.lingoquest.adapters.output.persistence.postgres.mappers

import com.yonatan.lingoquest.adapters.output.persistence.postgres.data.AnswerData
import com.yonatan.lingoquest.domain.entity.Answer

object AnswerMapper {
    fun Answer.toEntity() =
        AnswerData(
            answer = content,
            isCorrect = isCorrect,
        )

    fun List<Answer>.toEntity(): List<AnswerData> = map { it.toEntity() }

    fun toDomain(answerData: AnswerData): Answer =
        Answer(
            content = requireNotNull(answerData.answer) { "Answer content must not be null" },
            isCorrect = answerData.isCorrect,
        )

    fun List<AnswerData>.toDomain() = map { toDomain(it) }

    fun List<AnswerData>.findAllCorrectAnswers(): List<Answer> = filter { it.isCorrect }.map { toDomain(it) }
}
