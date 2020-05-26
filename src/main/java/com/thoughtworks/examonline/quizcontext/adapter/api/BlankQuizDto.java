package com.thoughtworks.examonline.quizcontext.adapter.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author gitqh
 */
@Getter
@AllArgsConstructor
public class BlankQuizDto {
    private String blankQuizId;

    public static BlankQuizDto from(String paperId) {
        return new BlankQuizDto(paperId);
    }
}
