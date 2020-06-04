package com.thoughtworks.examonline.examcontext.adapter.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author gitqh
 */
@Getter
@AllArgsConstructor
public class ExaminationDto {
    private String examinationId;

    public static ExaminationDto from(final String examinationId) {
        return new ExaminationDto(examinationId);
    }
}
