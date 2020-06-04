package com.thoughtworks.examonline.examcontext.adapter.repository;

import com.google.common.collect.Sets;
import com.thoughtworks.examonline.examcontext.domain.model.examination.Examination;
import com.thoughtworks.examonline.examcontext.domain.model.examination.ExaminationId;
import com.thoughtworks.examonline.examcontext.domain.model.examination.ExaminationRepository;
import java.time.LocalDateTime;
import java.util.Set;
import org.springframework.stereotype.Repository;

/**
 * @author gitqh
 */
@SuppressWarnings("checkstyle:magicnumber")
@Repository
public class MemoryExaminationRepository implements ExaminationRepository {
    private final Set<Examination> examinations = Sets.newHashSet();

    {
        examinations.add(Examination.builder()
                .id(new ExaminationId("Examination001"))
                .paperId("Paper001")
                .build());
    }

    @Override
    public void save(final Examination examination) {
        var existed = examinations.stream().anyMatch(e -> e.equals(examination));
        if (existed) {
            examinations.stream().filter(e -> e.equals(examination)).forEach(
                    o -> {
                        o.setPaperId(examination.getPaperId());
                        o.setStartDate(examination.getStartDate());
                        o.setUpdateTime(LocalDateTime.now());
                    }
            );
        } else {
            examinations.add(examination);
        }
    }
}
