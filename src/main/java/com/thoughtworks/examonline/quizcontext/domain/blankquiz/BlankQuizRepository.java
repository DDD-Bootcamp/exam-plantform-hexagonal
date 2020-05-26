package com.thoughtworks.examonline.quizcontext.domain.blankquiz;

public interface BlankQuizRepository {

    void save(BlankQuiz blankQuiz);

    void delete(String id);
}
