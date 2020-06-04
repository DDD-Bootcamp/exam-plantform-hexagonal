package com.thoughtworks.examonline.examcontext.application;

import com.thoughtworks.examonline.examcontext.domain.model.examination.Examination;
import com.thoughtworks.examonline.examcontext.domain.model.examination.ExaminationId;
import com.thoughtworks.examonline.examcontext.domain.model.examination.ExaminationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author gitqh
 */
@Service
@AllArgsConstructor
public class ExaminationApplicationService {
    private final ExaminationRepository examinationRepository;

    public ExaminationId create(final CreateExaminationCommand command) {
        var examination = Examination.create(command.getPaperId(), command.getStartDate());
        examinationRepository.save(examination);
        return examination.getId();
    }
}
