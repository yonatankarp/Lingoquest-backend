package com.yonatan.learnlanguage.domain.entity

import com.yonatan.learnlanguage.domain.valueobject.QuizStatus
import java.util.UUID

data class Quiz(
    val id: UUID,
    val questions: List<Question>,
    val status: QuizStatus,
) {
    fun completeQuiz(): Quiz {
        require(this.status == QuizStatus.OPEN) { "Quiz already completed or abandoned" }
        return copy(status = QuizStatus.COMPLETED)
    }
}
