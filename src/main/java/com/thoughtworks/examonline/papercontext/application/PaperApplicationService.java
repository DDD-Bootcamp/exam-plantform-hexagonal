package com.thoughtworks.examonline.papercontext.application;

import com.thoughtworks.examonline.papercontext.domain.model.Paper;
import com.thoughtworks.examonline.papercontext.domain.model.Paper.BlankQuiz;
import com.thoughtworks.examonline.papercontext.domain.model.Paper.BlankQuizId;
import com.thoughtworks.examonline.papercontext.domain.model.PaperId;
import com.thoughtworks.examonline.papercontext.domain.model.PaperRepository;
import java.util.List;
import java.util.Set;
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

    public PaperId assemblePaper(final AssemblePaperCommand command) {
        var blankQuizzes = blankQuizFrom(command);
        var teacherId = command.getTeacherId();
        var paper = Paper.assemble(blankQuizzes, teacherId);
        paperRepository.save(paper);
        return paper.getId();
    }

    public PaperId reassemblePaper(final String paperId, final AssemblePaperCommand command) {
        var blankQuizzes = blankQuizFrom(command);
        var teacherId = command.getTeacherId();
        var paper = paperRepository.find(new PaperId(paperId));
        var newPaper = paper.reassemble(blankQuizzes, teacherId);
        paperRepository.save(newPaper);
        return newPaper.getId();
    }

    private List<BlankQuiz> blankQuizFrom(AssemblePaperCommand command) {
        return command.getQuizzes().stream()
                .map(quiz -> new BlankQuiz(new BlankQuizId(quiz.getQuizId()), quiz.getScore()))
                .collect(Collectors.toList());
    }

    public Set<Paper> getAll() {
        return paperRepository.getAll();
    }
}
