package com.thoughtworks.examonline.certcontext.application;

import com.thoughtworks.examonline.certcontext.domain.model.certification.Certification;
import com.thoughtworks.examonline.certcontext.domain.model.certification.CertificationId;
import com.thoughtworks.examonline.certcontext.domain.model.certification.CertificationRepository;
import com.thoughtworks.examonline.certcontext.domain.service.CertificationGenerateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author gitqh
 */
@Service
@AllArgsConstructor
public class CertificationApplicationService {
    private CertificationRepository certificationRepository;
    private CertificationGenerateService certificationGenerateService;

    public CertificationId generate(final GenerateCertificationCommand command) {
        var fileLink = certificationGenerateService.generate(command.getStudentName(), command.getCourse());
        var certification = Certification.create(command.getStudentName(), command.getCourse(),
                fileLink);
        certificationRepository.save(certification);
        return certification.getId();
    }
}
