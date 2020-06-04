package com.thoughtworks.examonline.answersheetcontext.application;

import com.thoughtworks.examonline.answersheetcontext.domain.model.answersheet.AnswerSheet.Answer;
import com.thoughtworks.examonline.answersheetcontext.domain.model.answersheet.AnswerSheetId;
import java.util.Set;
import lombok.Data;

/**
 * @author gitqh
 */
@Data
public class HandInCommand {
    private AnswerSheetId id;
    private Set<Answer> answers;
}
