package com.thoughtworks.examonline.papercontext.domain;

import com.thoughtworks.examonline.common.ddd.annotation.ValueObject;
import lombok.AllArgsConstructor;

/**
 * @author gitqh
 */
@ValueObject
@AllArgsConstructor
public class UniqueQuizSpecification implements PaperSpecification{
    @Override
    public boolean isSatisfiedBy(Paper paper) {
        return paper.getBlankQuizzes().stream().distinct().count() == paper.getBlankQuizzes().size();
    }
}
