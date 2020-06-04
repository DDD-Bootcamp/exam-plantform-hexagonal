package com.thoughtworks.examonline.certcontext.adapter.client;

import java.util.Base64;
import org.springframework.stereotype.Component;

/**
 * @author gitqh
 */
@Component
public class CertificationClient {

    public String generate(final String studentName, final String courseName, final String description) {
        String value = studentName + courseName + description;
        return "https://drive.google.com/drive/folders/certifications/"
                + Base64.getEncoder().encodeToString(value.getBytes());
    }
}
