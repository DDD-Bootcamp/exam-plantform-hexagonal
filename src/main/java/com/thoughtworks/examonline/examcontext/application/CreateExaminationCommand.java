package com.thoughtworks.examonline.examcontext.application;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author gitqh
 */
@Getter
@AllArgsConstructor
public class CreateExaminationCommand {
    private String paperId;
    private LocalDate startDate;
}
