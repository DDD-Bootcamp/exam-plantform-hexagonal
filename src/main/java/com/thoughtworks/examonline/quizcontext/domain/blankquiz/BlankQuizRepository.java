package com.thoughtworks.examonline.quizcontext.domain.blankquiz;

public interface BlankQuizRepository {

    void save(BlankQuiz blankQuiz);

    void delete(BlankQuizId id);

    BlankQuiz find(BlankQuizId blankQuizId);
}
