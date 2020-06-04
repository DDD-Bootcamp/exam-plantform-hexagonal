package com.thoughtworks.examonline.answersheetcontext.domain.model.answersheet;

public interface AnswerSheetRepository {

    void save(AnswerSheet answerSheet);

    AnswerSheet findById(AnswerSheetId id);
}
