package com.yonatan.lingoquest.adapters.output.persistence.postgres

import com.yonatan.lingoquest.adapters.output.persistence.postgres.data.QuizData
import com.yonatan.lingoquest.domain.entity.Quiz
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface QuizHibernatePostgresRepository : CrudRepository<QuizData, Long> {
    fun findByQuizId(quizId: UUID): Quiz?
}
