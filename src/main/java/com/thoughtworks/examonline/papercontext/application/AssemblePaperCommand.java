package com.thoughtworks.examonline.papercontext.application;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

/**
 * @author gitqh
 */
@Data
@AllArgsConstructor
public class AssemblePaperCommand {
    private String teacherId;
    private List<Quiz> quizzes;

    @Value
    public static class Quiz {
        String quizId;
        int score;
    }
}

