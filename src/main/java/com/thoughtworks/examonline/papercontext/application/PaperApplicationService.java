package com.thoughtworks.examonline.papercontext.application;

import com.thoughtworks.examonline.papercontext.adapter.api.command.AssemblePaperCommand;
import com.thoughtworks.examonline.papercontext.domain.model.paper.IllegalQuizzesCountException;
import com.thoughtworks.examonline.papercontext.domain.model.paper.Paper;
import com.thoughtworks.examonline.papercontext.domain.model.paper.Paper.BlankQuiz;
import com.thoughtworks.examonline.papercontext.domain.model.paper.PaperId;
import com.thoughtworks.examonline.papercontext.domain.model.paper.PaperRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author gitqh
 */
@Service
@AllArgsConstructor
public class PaperApplicationService {
    private final PaperRepository paperRepository;

    public PaperId assemblePaper(final AssemblePaperCommand command)
            throws IllegalQuizzesCountException {
        var blankQuizzes = blankQuizFrom(command);
        var teacherId = command.getTeacherId();
        var paper = Paper.assemble(blankQuizzes, teacherId);
        paperRepository.save(paper);
        return paper.getId();
    }

    public PaperId reassemblePaper(final String paperId, final AssemblePaperCommand command)
            throws IllegalQuizzesCountException {
        var blankQuizzes = blankQuizFrom(command);
        var teacherId = command.getTeacherId();
        var paper = paperRepository.find(new PaperId(paperId));
        var newPaper = paper.reassemble(blankQuizzes, teacherId);
        paperRepository.save(newPaper);
        return newPaper.getId();
    }

    private List<BlankQuiz> blankQuizFrom(final AssemblePaperCommand command) {
        return command.getQuizzes().stream()
                .map(quiz -> new BlankQuiz(quiz.getQuizId(), quiz.getScore()))
                .collect(Collectors.toList());
    }
}
