package com.thoughtworks.examonline.papercontext.domain.model;

import com.thoughtworks.examonline.common.ddd.annotation.ValueObject;
import lombok.AllArgsConstructor;

/**
 * @author gitqh
 */
@ValueObject
@AllArgsConstructor
public class QuizCountSpecification implements PaperSpecification {
    @Override
    public boolean isSatisfiedBy(Paper paper) {
        return paper.getBlankQuizzes().size() >= 5 && paper.getBlankQuizzes().size() <= 20;
    }
}
