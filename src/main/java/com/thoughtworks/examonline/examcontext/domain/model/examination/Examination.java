package com.thoughtworks.examonline.examcontext.domain.model.examination;

import com.thoughtworks.examonline.common.ddd.annotation.AggregateRoot;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author gitqh
 */
@AggregateRoot
@AllArgsConstructor
@Data
@Builder
public class Examination {
    private ExaminationId id;
    private String paperId;
    private LocalDate startDate;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public static Examination create(final String paperId, final LocalDate startDate) {
        return Examination.builder()
                .id(ExaminationId.generate())
                .paperId(paperId)
                .startDate(startDate)
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
    }
}
