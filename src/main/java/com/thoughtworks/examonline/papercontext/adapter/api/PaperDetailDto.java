package com.thoughtworks.examonline.papercontext.adapter.api;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author gitqh
 */
@Data
@AllArgsConstructor
public class PaperDetailDto {
    private String id;
    public static PaperDetailDto from() {
        return null;
    }
}
