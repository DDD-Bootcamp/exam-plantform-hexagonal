package com.thoughtworks.examonline.answersheetcontext.application;

import com.thoughtworks.examonline.answersheetcontext.domain.model.answersheet.AnswerSheetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author gitqh
 */
@Service
@AllArgsConstructor
public class AnswerSheetApplicationService {
    private final AnswerSheetRepository answerSheetRepository;

    public void assign() {

    }

    public void submit(final SubmitAnswerCommand command) {
        var answerSheet = answerSheetRepository.findById(command.getAnswerSheet().getId());
        answerSheetRepository.save(answerSheet);
    }

    public void handin(final HandInCommand command) {
        var answerSheet = answerSheetRepository.findById(command.getId());
        answerSheet.setAnswers(command.getAnswers());
        answerSheetRepository.save(answerSheet);
    }

    public void review(final ReviewAnswerSheetCommand command) {
        var answerSheet = answerSheetRepository.findById(command.getId());
        answerSheet.review();
        answerSheetRepository.save(answerSheet);
    }
}
