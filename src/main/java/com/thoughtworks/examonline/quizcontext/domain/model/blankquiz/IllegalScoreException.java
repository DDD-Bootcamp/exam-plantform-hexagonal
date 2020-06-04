package com.thoughtworks.examonline.quizcontext.domain.model.blankquiz;

/**
 * @author gitqh
 */
public class IllegalScoreException extends Throwable {
    public IllegalScoreException(final Integer score) {
        super(score.toString());
    }
}
