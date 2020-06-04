package com.thoughtworks.examonline.answersheetcontext.domain.model.answersheet;

import com.thoughtworks.examonline.common.ddd.annotation.ValueObject;
import com.thoughtworks.examonline.common.ddd.core.AbstractId;
import java.util.UUID;
import lombok.EqualsAndHashCode;

/**
 * @author gitqh
 */
@ValueObject
@EqualsAndHashCode(callSuper = true)
public class AnswerSheetId extends AbstractId {
    public AnswerSheetId(final String value) {
        super(value);
    }

    public AnswerSheetId generate() {
        return new AnswerSheetId("answersheet-" + UUID.randomUUID().toString());
    }
}
