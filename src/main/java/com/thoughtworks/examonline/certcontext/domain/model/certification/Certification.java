package com.thoughtworks.examonline.certcontext.domain.model.certification;

import com.thoughtworks.examonline.common.ddd.annotation.AggregateRoot;
import com.thoughtworks.examonline.common.ddd.annotation.ValueObject;
import com.thoughtworks.examonline.coursecontext.domain.model.course.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author gitqh
 */
@AggregateRoot
@Data
@AllArgsConstructor
@Builder
public class Certification {
    private CertificationId id;
    private String studentName;
    private Course course;
    private String fileLink;

    public static Certification create(final String studentName, final Course course,
                                       final String fileLink) {
        return Certification.builder()
                .id(CertificationId.generate())
                .studentName(studentName)
                .course(course)
                .fileLink(fileLink)
                .build();
    }

    @ValueObject
    @Data
    @AllArgsConstructor
    @Builder
    public static class Course {
        private String courseName;
        private String description;
    }
}
