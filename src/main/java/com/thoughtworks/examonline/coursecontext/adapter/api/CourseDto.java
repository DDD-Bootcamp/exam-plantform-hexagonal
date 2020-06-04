package com.thoughtworks.examonline.coursecontext.adapter.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author gitqh
 */
@AllArgsConstructor
@Getter
public class CourseDto {

    private String courseId;

    public static CourseDto from(final String courseId) {
        return new CourseDto(courseId);
    }
}
