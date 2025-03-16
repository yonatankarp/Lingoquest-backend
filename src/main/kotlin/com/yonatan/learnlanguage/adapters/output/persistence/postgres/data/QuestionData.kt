package com.yonatan.learnlanguage.adapters.output.persistence.postgres.data

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "questions")
data class QuestionData(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,

    @Column(nullable = false, unique = true)
    var questionId: UUID? = null,

    var question: String? = null,

    var questionType: String? = null,

    @OneToMany(mappedBy = "question", cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = true)
    var options: List<AnswerData> = emptyList(),

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    var quiz: QuizData? = null
)
