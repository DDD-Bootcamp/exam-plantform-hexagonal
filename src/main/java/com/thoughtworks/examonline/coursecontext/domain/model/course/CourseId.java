package com.thoughtworks.examonline.coursecontext.domain.model.course;

import com.thoughtworks.examonline.common.ddd.annotation.ValueObject;
import com.thoughtworks.examonline.common.ddd.core.AbstractId;
import java.util.UUID;
import lombok.EqualsAndHashCode;

/**
 * @author gitqh
 */
@ValueObject
@EqualsAndHashCode(callSuper = true)
public class CourseId extends AbstractId {
    public CourseId(final String value) {
        super(value);
    }

    public static CourseId generate() {
        return new CourseId("course-" + UUID.randomUUID().toString());
    }
}
