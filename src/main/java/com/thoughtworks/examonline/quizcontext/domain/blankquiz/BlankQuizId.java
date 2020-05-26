package com.thoughtworks.examonline.quizcontext.domain.blankquiz;

import com.thoughtworks.examonline.common.ddd.annotation.ValueObject;
import com.thoughtworks.examonline.common.ddd.core.AbstractId;
import java.util.UUID;
import lombok.EqualsAndHashCode;

/**
 * @author gitqh
 */
@ValueObject
@EqualsAndHashCode(callSuper = true)
public class BlankQuizId extends AbstractId {
    public BlankQuizId(final String value) {
        super(value);
    }

    public static BlankQuizId generate() {
        return new BlankQuizId(UUID.randomUUID().toString());
    }
}
