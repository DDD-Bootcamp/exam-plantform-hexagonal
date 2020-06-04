package com.thoughtworks.examonline.certcontext.application;

import com.thoughtworks.examonline.certcontext.domain.model.certification.Certification.Course;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author gitqh
 */
@Data
@AllArgsConstructor
public class GenerateCertificationCommand {
    private String studentName;
    private Course course;
}
