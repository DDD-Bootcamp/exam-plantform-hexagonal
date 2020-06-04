package com.thoughtworks.examonline.coursecontext.domain.model.course;

import com.thoughtworks.examonline.common.ddd.annotation.AggregateRoot;
import com.thoughtworks.examonline.common.ddd.annotation.ValueObject;
import com.thoughtworks.examonline.common.ddd.core.AbstractId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author gitqh
 */
@AggregateRoot
@Data
@AllArgsConstructor
@Builder
public class Course {
    private CourseId id;
    private CourseStateEnum statue;
    private String videoDriveLink;
    private String createdBy;
    private String lastUpdatedBy;
    private ExaminationId examinationId;

    public static Course create(final String createdBy,
                                final String lastUpdatedBy, final ExaminationId examinationId) {
        return Course.builder()
                .id(CourseId.generate())
                .statue(CourseStateEnum.CREATED)
                .createdBy(createdBy)
                .lastUpdatedBy(lastUpdatedBy)
                .examinationId(examinationId)
                .build();
    }

    @ValueObject
    @EqualsAndHashCode(callSuper = true)
    public static class ExaminationId extends AbstractId {
        public ExaminationId(final String value) {
            super(value);
        }
    }
}
