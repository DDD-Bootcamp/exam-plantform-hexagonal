package com.thoughtworks.examonline.quizcontext.domain.blankquiz;

import com.thoughtworks.examonline.common.ddd.annotation.AggregateRoot;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author gitqh
 */
@AggregateRoot
@Data
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class BlankQuiz {
    private BlankQuizId id;
    private String teacherId;
    private String question;
    private Integer score;
    private String referenceAnswer;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public static BlankQuiz create(final String teacherId, final String question,
                                   final Integer score, final String referenceAnswer) {
        return BlankQuiz.builder()
                .id(BlankQuizId.generate())
                .teacherId(teacherId)
                .question(question)
                .score(score)
                .referenceAnswer(referenceAnswer)
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
    }

    public BlankQuiz update(final BlankQuizId id, final String teacherId, final String question,
                       final Integer score, final String referenceAnswer) {
        return BlankQuiz.builder()
                .id(id)
                .teacherId(teacherId)
                .question(question)
                .score(score)
                .referenceAnswer(referenceAnswer)
                .updateTime(LocalDateTime.now())
                .build();
    }
}
