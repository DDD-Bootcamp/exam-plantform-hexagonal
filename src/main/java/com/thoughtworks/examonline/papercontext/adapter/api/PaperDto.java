package com.thoughtworks.examonline.papercontext.adapter.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author gitqh
 */
@Getter
@AllArgsConstructor
public class PaperDto {
    private String paperId;

    public static PaperDto from(String paperId) {
        return new PaperDto(paperId);
    }
}
