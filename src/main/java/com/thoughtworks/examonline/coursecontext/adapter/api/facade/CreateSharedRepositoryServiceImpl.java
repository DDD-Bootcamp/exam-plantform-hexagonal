package com.thoughtworks.examonline.coursecontext.adapter.api.facade;

import com.thoughtworks.examonline.coursecontext.adapter.client.GoogleDriveClient;
import com.thoughtworks.examonline.coursecontext.domain.service.CreateSharedRepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author gitqh
 */
@Component
@AllArgsConstructor
public class CreateSharedRepositoryServiceImpl implements CreateSharedRepositoryService {
    private final GoogleDriveClient client;

    @Override
    public String createSharedRepository(final String courseId) {
        return client.createDrive(courseId);
    }
}
