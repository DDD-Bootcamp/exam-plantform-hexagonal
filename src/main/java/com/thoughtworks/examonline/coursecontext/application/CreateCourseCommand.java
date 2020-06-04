package com.thoughtworks.examonline.coursecontext.application;

import com.thoughtworks.examonline.coursecontext.domain.model.course.Course.ExaminationId;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author gitqh
 */
@AllArgsConstructor
@Data
public class CreateCourseCommand {
    private String createdBy;
    private String lastUpdatedBy;
    private ExaminationId examinationId;
}
