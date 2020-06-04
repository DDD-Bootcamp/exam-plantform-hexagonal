package com.thoughtworks.examonline.coursecontext.adapter.api;

import com.thoughtworks.examonline.coursecontext.application.CourseApplicationService;
import com.thoughtworks.examonline.coursecontext.application.CreateCourseCommand;
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
@RequestMapping("/courses")
public class CourseController {
    private CourseApplicationService courseApplicationService;

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDto create(@RequestBody final CreateCourseCommand command) {
        var courseId = courseApplicationService.create(command);
        return CourseDto.from(courseId.toString());
    }
}
