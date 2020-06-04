package com.thoughtworks.examonline.coursecontext.application;

import com.thoughtworks.examonline.coursecontext.domain.model.course.Course;
import com.thoughtworks.examonline.coursecontext.domain.model.course.CourseId;
import com.thoughtworks.examonline.coursecontext.domain.model.course.CourseRepository;
import com.thoughtworks.examonline.coursecontext.domain.service.CreateSharedRepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author gitqh
 */
@Service
@AllArgsConstructor
public class CourseApplicationService {
    private final CourseRepository courseRepository;
    private final CreateSharedRepositoryService createSharedRepositoryService;

    public CourseId create(final CreateCourseCommand command) {
        var course = Course.create(command.getCreatedBy(),
                command.getLastUpdatedBy(), command.getExaminationId());
        var videoDriveLink = createSharedRepositoryService.createSharedRepository(course.getId().toString());
        course.setVideoDriveLink(videoDriveLink);
        courseRepository.save(course);
        return course.getId();
    }
}
