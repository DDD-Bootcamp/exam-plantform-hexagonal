package com.thoughtworks.examonline.certcontext.adapter.repository;

import com.google.common.collect.Sets;
import com.thoughtworks.examonline.certcontext.domain.model.certification.Certification;
import com.thoughtworks.examonline.certcontext.domain.model.certification.Certification.Course;
import com.thoughtworks.examonline.certcontext.domain.model.certification.CertificationId;
import com.thoughtworks.examonline.certcontext.domain.model.certification.CertificationRepository;
import java.util.Set;
import org.springframework.stereotype.Repository;

/**
 * @author gitqh
 */
@Repository
public class CertificationMemRepository implements CertificationRepository {

    private final Set<Certification> certifications = Sets.newHashSet();

    {
        certifications.add(Certification.builder()
                .id(new CertificationId("Certification-001"))
                .course(
                        Course.builder()
                                .courseName("Math")
                                .description("Magic Math")
                                .build())
                .fileLink("https://drive.google.com/drive/folders/certifications/001")
                .studentName("San Zhang")
                .build());
    }

    @Override
    public void save(final Certification certification) {
        var existed = certifications.stream().anyMatch(e -> e.equals(certification));
        if (existed) {
            certifications.stream().filter(e -> e.equals(certification)).forEach(
                    o -> {
                        o.setId(certification.getId());
                        o.setCourse(certification.getCourse());
                        o.setFileLink(certification.getFileLink());
                        o.setStudentName(certification.getStudentName());
                    }
            );
        } else {
            certifications.add(certification);
        }
    }
}
