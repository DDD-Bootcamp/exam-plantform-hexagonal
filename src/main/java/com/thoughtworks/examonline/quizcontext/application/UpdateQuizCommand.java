package com.thoughtworks.examonline.quizcontext.application;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author gitqh
 */
@Data
@AllArgsConstructor
public class UpdateQuizCommand {
    private String teacherId;
    private String question;
    private Integer score;
    private String referenceAnswer;
}
