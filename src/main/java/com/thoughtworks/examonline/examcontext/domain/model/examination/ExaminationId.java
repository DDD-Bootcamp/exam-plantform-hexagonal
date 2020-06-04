package com.thoughtworks.examonline.examcontext.domain.model.examination;

import com.thoughtworks.examonline.common.ddd.annotation.ValueObject;
import com.thoughtworks.examonline.common.ddd.core.AbstractId;
import java.util.UUID;
import lombok.EqualsAndHashCode;

/**
 * @author gitqh
 */
@ValueObject
@EqualsAndHashCode(callSuper = true)
public class ExaminationId extends AbstractId {
    public ExaminationId(final String value) {
        super(value);
    }

    public static ExaminationId generate() {
        return new ExaminationId("exam-" + UUID.randomUUID().toString());
    }
}
