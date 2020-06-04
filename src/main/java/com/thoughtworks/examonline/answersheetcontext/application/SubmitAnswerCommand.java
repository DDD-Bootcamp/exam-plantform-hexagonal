package com.thoughtworks.examonline.answersheetcontext.application;

import com.thoughtworks.examonline.answersheetcontext.domain.model.answersheet.AnswerSheet;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author gitqh
 */
@AllArgsConstructor
@Data
public class SubmitAnswerCommand {
    private AnswerSheet answerSheet;
}
