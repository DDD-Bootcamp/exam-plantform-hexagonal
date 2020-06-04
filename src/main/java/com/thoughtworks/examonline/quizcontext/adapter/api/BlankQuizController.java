package com.thoughtworks.examonline.quizcontext.adapter.api;

import com.thoughtworks.examonline.quizcontext.application.BlankQuizApplicationService;
import com.thoughtworks.examonline.quizcontext.application.CreateQuizCommand;
import com.thoughtworks.examonline.quizcontext.application.DeleteQuizCommand;
import com.thoughtworks.examonline.quizcontext.application.UpdateQuizCommand;
import com.thoughtworks.examonline.quizcontext.domain.model.blankquiz.IllegalScoreException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gitqh
 */
@RestController
@RequestMapping("/quizzes")
public class BlankQuizController {
    private BlankQuizApplicationService blankQuizApplicationService;

    @DeleteMapping("/{quizId}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable final String quizId) {
        blankQuizApplicationService.deleteQuiz(new DeleteQuizCommand(quizId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlankQuizDto create(@RequestBody final CreateQuizCommand command) throws IllegalScoreException {
        return BlankQuizDto.from(blankQuizApplicationService.createQuiz(command).toString());
    }

    @PutMapping("/{quizId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public BlankQuizDto update(@PathVariable final String quizId,
                               @RequestBody final UpdateQuizCommand command) {
        return BlankQuizDto.from(blankQuizApplicationService.updateQuiz(quizId, command).toString());
    }
}
