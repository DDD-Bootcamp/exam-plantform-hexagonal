package com.thoughtworks.examonline.certcontext.domain.model.certification;

import com.thoughtworks.examonline.common.ddd.annotation.ValueObject;
import com.thoughtworks.examonline.common.ddd.core.AbstractId;
import java.util.UUID;
import lombok.EqualsAndHashCode;

/**
 * @author gitqh
 */
@ValueObject
@EqualsAndHashCode(callSuper = true)
public class CertificationId extends AbstractId {
    public CertificationId(final String value) {
        super(value);
    }

    public static CertificationId generate() {
        return new CertificationId("cert-" + UUID.randomUUID().toString());
    }
}
