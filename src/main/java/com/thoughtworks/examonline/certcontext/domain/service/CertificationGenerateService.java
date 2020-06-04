package com.thoughtworks.examonline.certcontext.domain.service;


import com.thoughtworks.examonline.certcontext.domain.model.certification.Certification.Course;

/**
 * @author gitqh
 */
public interface CertificationGenerateService {
    String generate(String studentName, Course course);
}
