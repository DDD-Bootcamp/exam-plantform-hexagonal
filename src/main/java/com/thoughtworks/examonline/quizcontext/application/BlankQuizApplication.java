package com.thoughtworks.examonline.quizcontext.application;

import com.thoughtworks.examonline.quizcontext.domain.blankquiz.BlankQuiz;
import com.thoughtworks.examonline.quizcontext.domain.blankquiz.BlankQuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author gitqh
 */
@Service
@AllArgsConstructor
public class BlankQuizApplication {
    private BlankQuizRepository blankQuizRepository;

    public void create(final String teacherId) {
        var blankQuiz = BlankQuiz.create(teacherId);
        blankQuizRepository.save(blankQuiz);
    }

    public void update(final BlankQuiz blankQuiz) {
        blankQuizRepository.save(blankQuiz);
    }

    public void delete(final String id) {
        blankQuizRepository.delete(id);
    }
}
