package com.thoughtworks.examonline.answersheetcontext.domain.model.answersheet;

import com.thoughtworks.examonline.common.ddd.annotation.AggregateRoot;
import com.thoughtworks.examonline.common.ddd.annotation.ValueObject;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author gitqh
 */
@AggregateRoot
@Data
@AllArgsConstructor
@Builder
public class AnswerSheet {
    private AnswerSheetId id;
    private String studentId;
    private int score;
    private Set<Answer> answers;

    public void review() {
        score = answers.stream()
                .filter(Answer::compare)
                .map(answer -> answer.getBlankQuiz().getScore())
                .mapToInt(Integer::intValue).sum();
    }

    @ValueObject
    @Data
    @AllArgsConstructor
    @Builder
    public static class Answer {
        private Integer number;
        private BlankQuiz blankQuiz;
        private String answer;
        private String referenceAnswer;

        public boolean compare() {
            return referenceAnswer.contains(answer);
        }
    }

    @ValueObject
    @Data
    @AllArgsConstructor
    @Builder
    public static class BlankQuiz {
        private String content;
        private Integer score;
    }
}
