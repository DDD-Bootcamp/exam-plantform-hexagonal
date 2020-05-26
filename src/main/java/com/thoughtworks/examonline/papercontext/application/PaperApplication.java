package com.thoughtworks.examonline.papercontext.application;

import com.thoughtworks.examonline.papercontext.domain.Paper;
import com.thoughtworks.examonline.papercontext.domain.Paper.BlankQuiz;
import com.thoughtworks.examonline.papercontext.domain.PaperId;
import com.thoughtworks.examonline.papercontext.domain.PaperRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author gitqh
 */
@Service
@AllArgsConstructor
public class PaperApplication {
    private PaperRepository paperRepository;

    public void assemble(final List<BlankQuiz> blankQuizzes, final String teacherId) {
        var paper = Paper.assemble(blankQuizzes, teacherId);
        paperRepository.save(paper);
    }

    public void reassemble(final PaperId paperId, final List<BlankQuiz> blankQuizzes,
                           final String teacherId) {
        var paper = Paper.reassemble(paperId, blankQuizzes, teacherId);
        paperRepository.save(paper);
    }
}
