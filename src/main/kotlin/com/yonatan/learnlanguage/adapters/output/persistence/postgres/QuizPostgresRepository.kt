package com.yonatan.learnlanguage.adapters.output.persistence.postgres

import com.yonatan.learnlanguage.adapters.output.persistence.postgres.mappers.QuizMapper.toDomain
import com.yonatan.learnlanguage.adapters.output.persistence.postgres.mappers.QuizMapper.toEntity
import com.yonatan.learnlanguage.application.ports.QuizRepository
import com.yonatan.learnlanguage.domain.entity.Quiz
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class QuizPostgresRepository(
    private val repository: QuizHibernatePostgresRepository,
) : QuizRepository {
    override fun save(quiz: Quiz): Quiz {
        val entity = quiz.toEntity()
        return repository.save(entity).toDomain()
    }

    override fun findById(id: UUID): Quiz? {
        val quiz = repository.findByQuizId(id)
        return quiz
    }
}
