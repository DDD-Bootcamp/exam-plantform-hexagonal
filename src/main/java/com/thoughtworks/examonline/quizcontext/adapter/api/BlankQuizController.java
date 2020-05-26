package com.thoughtworks.examonline.quizcontext.adapter.api;

import com.thoughtworks.examonline.quizcontext.application.BlankQuizApplicationService;
import com.thoughtworks.examonline.quizcontext.application.CreateQuizCommand;
import com.thoughtworks.examonline.quizcontext.application.DeleteQuizCommand;
import com.thoughtworks.examonline.quizcontext.application.UpdateQuizCommand;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gitqh
 */
@RestController
public class BlankQuizController {
    private BlankQuizApplicationService blankQuizApplicationService;

    @DeleteMapping("/quizzes/{quizId}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String quizId) {
        blankQuizApplicationService.deleteQuiz(new DeleteQuizCommand(quizId));
    }

    @PostMapping("/quizzes")
    @ResponseStatus(HttpStatus.CREATED)
    public BlankQuizDto create(@RequestBody CreateQuizCommand command) {
        return BlankQuizDto.from(blankQuizApplicationService.createQuiz(command).toString());
    }

    @PutMapping("/quizzes/{quizId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public BlankQuizDto update(@PathVariable String quizId, @RequestBody UpdateQuizCommand command) {
        return BlankQuizDto.from(blankQuizApplicationService.updateQuiz(quizId, command).toString());
    }
}
