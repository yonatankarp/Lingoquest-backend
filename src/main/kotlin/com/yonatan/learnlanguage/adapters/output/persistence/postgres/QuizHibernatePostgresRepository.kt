package com.yonatan.learnlanguage.adapters.output.persistence.postgres

import com.yonatan.learnlanguage.adapters.output.persistence.postgres.data.QuizData
import com.yonatan.learnlanguage.domain.entity.Quiz
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface QuizHibernatePostgresRepository : CrudRepository<QuizData, Long> {
    fun findByQuizId(quizId: UUID): Quiz?
}
