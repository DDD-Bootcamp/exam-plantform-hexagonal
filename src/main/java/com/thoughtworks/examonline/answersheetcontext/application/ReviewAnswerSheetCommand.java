package com.thoughtworks.examonline.answersheetcontext.application;

import com.thoughtworks.examonline.answersheetcontext.domain.model.answersheet.AnswerSheetId;
import lombok.Data;

/**
 * @author gitqh
 */
@Data
public class ReviewAnswerSheetCommand {
    private AnswerSheetId id;
}
