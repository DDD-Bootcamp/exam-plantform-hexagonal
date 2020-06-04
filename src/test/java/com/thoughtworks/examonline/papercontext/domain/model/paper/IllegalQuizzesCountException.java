package com.thoughtworks.examonline.papercontext.domain.model.paper;

/**
 * @author gitqh
 */
class IllegalQuizzesCountException extends IllegalArgumentException {

    public IllegalQuizzesCountException(int actual) {
        super("TooManyQuizzesException: exception:5~20, actual:" + actual);
    }
}
