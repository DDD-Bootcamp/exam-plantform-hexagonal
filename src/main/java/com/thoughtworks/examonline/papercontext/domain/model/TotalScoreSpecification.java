package com.thoughtworks.examonline.papercontext.domain.model;

import com.thoughtworks.examonline.common.ddd.annotation.ValueObject;
import com.thoughtworks.examonline.papercontext.domain.model.Paper.BlankQuiz;
import lombok.AllArgsConstructor;

/**
 * @author gitqh
 */
@ValueObject
@AllArgsConstructor
public class TotalScoreSpecification implements PaperSpecification{
    @Override
    public boolean isSatisfiedBy(Paper paper) {
        return paper.getBlankQuizzes().stream().map(BlankQuiz::getScore)
                .mapToInt(Integer::intValue).sum() == 100;
    }
}
