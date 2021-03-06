package com.thoughtworks.examonline.quizcontext.application;

import com.thoughtworks.examonline.quizcontext.domain.model.blankquiz.BlankQuiz;
import com.thoughtworks.examonline.quizcontext.domain.model.blankquiz.BlankQuizId;
import com.thoughtworks.examonline.quizcontext.domain.model.blankquiz.BlankQuizRepository;
import com.thoughtworks.examonline.quizcontext.domain.model.blankquiz.IllegalScoreException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author gitqh
 */
@Service
@AllArgsConstructor
public class BlankQuizApplicationService {
    private final BlankQuizRepository blankQuizRepository;

    public BlankQuizId createQuiz(final CreateQuizCommand command) throws IllegalScoreException {
        var blankQuiz = BlankQuiz.create(command.getTeacherId(), command.getQuestion(),
                command.getScore(), command.getReferenceAnswer());
        blankQuizRepository.save(blankQuiz);
        return blankQuiz.getId();
    }

    public BlankQuizId updateQuiz(final String quizId, final UpdateQuizCommand command) {
        var blankQuiz = blankQuizRepository.find(new BlankQuizId(quizId));
        var newBlankQuiz = blankQuiz.update(new BlankQuizId(quizId), command.getTeacherId(),
                command.getQuestion(), command.getScore(), command.getReferenceAnswer());
        blankQuizRepository.save(newBlankQuiz);
        return newBlankQuiz.getId();
    }

    public void deleteQuiz(final DeleteQuizCommand command) {
        blankQuizRepository.delete(new BlankQuizId(command.getQuizId()));
    }
}
