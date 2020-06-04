package com.thoughtworks.examonline.examcontext.adapter.api;

import com.thoughtworks.examonline.examcontext.application.CreateExaminationCommand;
import com.thoughtworks.examonline.examcontext.application.ExaminationApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gitqh
 */
@RestController
@RequestMapping("/examinations")
public class ExaminationController {
    private ExaminationApplicationService examinationApplicationService;

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ExaminationDto create(@RequestBody final CreateExaminationCommand command) {
        var examinationId = examinationApplicationService.create(command);
        return ExaminationDto.from(examinationId.toString());
    }
}
