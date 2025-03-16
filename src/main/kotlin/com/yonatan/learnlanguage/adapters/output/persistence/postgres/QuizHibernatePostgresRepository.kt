package com.yonatan.learnlanguage.adapters.output.persistence.postgres

import com.yonatan.learnlanguage.adapters.output.persistence.postgres.data.QuizData
import com.yonatan.learnlanguage.domain.entity.Quiz
import java.util.UUID
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface QuizHibernatePostgresRepository: CrudRepository<QuizData, Long> {
    fun findByQuizId(quizId: UUID): Quiz?
}
