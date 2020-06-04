package com.thoughtworks.examonline.papercontext.domain.model.paper;

import com.thoughtworks.examonline.common.ddd.annotation.ValueObject;
import com.thoughtworks.examonline.common.ddd.core.AbstractId;
import java.util.UUID;
import lombok.EqualsAndHashCode;

/**
 * @author gitqh
 */
@ValueObject
@EqualsAndHashCode(callSuper = true)
public
class PaperId extends AbstractId {
    public PaperId(final String value) {
        super(value);
    }

    public static PaperId generate() {
        return new PaperId("paper-" + UUID.randomUUID().toString());
    }
}
