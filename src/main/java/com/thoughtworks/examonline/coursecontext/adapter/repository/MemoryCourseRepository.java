package com.thoughtworks.examonline.coursecontext.adapter.repository;

import com.thoughtworks.examonline.coursecontext.domain.model.course.Course;
import com.thoughtworks.examonline.coursecontext.domain.model.course.CourseRepository;
import org.springframework.stereotype.Repository;

/**
 * @author gitqh
 */
@Repository
public class MemoryCourseRepository implements CourseRepository {
    @Override
    public void save(final Course course) {

    }
}
