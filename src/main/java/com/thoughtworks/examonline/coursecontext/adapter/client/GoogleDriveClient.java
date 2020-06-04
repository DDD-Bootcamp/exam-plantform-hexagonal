package com.thoughtworks.examonline.coursecontext.adapter.client;

import org.springframework.stereotype.Component;

/**
 * @author gitqh
 */
@Component
public class GoogleDriveClient {
    public String createDrive(final String courseId) {
        return "https://drive.google.com/drive/folders/" + courseId + "/videos";
    }
}
