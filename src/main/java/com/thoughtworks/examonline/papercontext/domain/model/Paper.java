package com.thoughtworks.examonline.papercontext.domain.model;

import com.thoughtworks.examonline.common.ddd.annotation.AggregateRoot;
import com.thoughtworks.examonline.common.ddd.annotation.Entity;
import com.thoughtworks.examonline.common.ddd.annotation.ValueObject;
import com.thoughtworks.examonline.common.ddd.core.AbstractId;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author gitqh
 */
@AggregateRoot
@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paper {
    private PaperId id;
    private List<BlankQuiz> blankQuizzes;
    private String teacherId;
    private LocalDateTime assembleTime;
    private LocalDateTime reassembleTime;

    public static Paper assemble(final List<BlankQuiz> blankQuizzes, final String teacherId) {
        return Paper.builder()
                .id(PaperId.generate())
                .blankQuizzes(blankQuizzes)
                .teacherId(teacherId)
                .assembleTime(LocalDateTime.now())
                .reassembleTime(LocalDateTime.now())
                .build();
    }

    public Paper reassemble(final List<BlankQuiz> blankQuizzes,
                            final String teacherId) {
        return Paper.builder()
                .id(id)
                .blankQuizzes(blankQuizzes)
                .teacherId(teacherId)
                .reassembleTime(LocalDateTime.now())
                .build();
    }

    @Entity
    @Data
    @Builder
    @AllArgsConstructor
    public static class BlankQuiz {
        private BlankQuizId id;
        private Integer score;
    }

    @ValueObject
    public static class BlankQuizId extends AbstractId {
        public BlankQuizId(final String value) {
            super(value);
        }
    }
}
