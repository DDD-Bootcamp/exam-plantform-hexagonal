package com.thoughtworks.examonline.quizcontext.application;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author gitqh
 */
@Data
@AllArgsConstructor
public class DeleteQuizCommand {
    private String quizId;
}
