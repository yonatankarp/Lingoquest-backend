package com.yonatan.learnlanguage.adapters.output

import com.yonatan.learnlanguage.application.ports.QuizRepository
import com.yonatan.learnlanguage.domain.entity.Quiz
import java.util.UUID
import org.springframework.stereotype.Component

@Component
class InMemoryQuizRepository : QuizRepository {

    private val store = mutableMapOf<UUID, Quiz>()

    override fun save(quiz: Quiz) = quiz.apply {
        store[quiz.id] = this
    }

    override fun findById(id: UUID): Quiz? = store[id]
}
