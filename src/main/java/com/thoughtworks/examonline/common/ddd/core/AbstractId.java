package com.thoughtworks.examonline.common.ddd.core;

import com.thoughtworks.examonline.common.ddd.annotation.ValueObject;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * @author gitqh
 */
@ValueObject
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public abstract class AbstractId implements Serializable {
    private String value;

    protected AbstractId() {

    }
}
