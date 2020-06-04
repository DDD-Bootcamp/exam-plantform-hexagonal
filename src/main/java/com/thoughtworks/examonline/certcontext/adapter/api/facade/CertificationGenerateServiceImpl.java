package com.thoughtworks.examonline.certcontext.adapter.api.facade;

import com.thoughtworks.examonline.certcontext.adapter.client.CertificationClient;
import com.thoughtworks.examonline.certcontext.domain.service.CertificationGenerateService;
import com.thoughtworks.examonline.certcontext.domain.model.certification.Certification.Course;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author gitqh
 */
@Component
@AllArgsConstructor
public class CertificationGenerateServiceImpl implements CertificationGenerateService {
    private final CertificationClient client;

    @Override
    public String generate(final String studentName, final Course course) {
        return client.generate(studentName, course.getCourseName(), course.getDescription());
    }
}
