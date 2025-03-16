package com.yonatan.learnlanguage.adapters.output.persistence.postgres.data

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "answers")
data class AnswerData(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,

    @Column(nullable = false)
    var answer: String? = null,

    @Column(nullable = false)
    var isCorrect: Boolean = false,

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    var question: QuestionData? = null
)
