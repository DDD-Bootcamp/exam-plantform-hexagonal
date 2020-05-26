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
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public static BlankQuiz create(final String teacherId) {
        return BlankQuiz.builder()
                .id(BlankQuizId.generate())
                .teacherId(teacherId)
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
    }
}
