package com.thoughtworks.examonline.papercontext.adapter.api;

import com.thoughtworks.examonline.papercontext.adapter.api.command.AssemblePaperCommand;
import com.thoughtworks.examonline.papercontext.application.PaperApplicationService;
import com.thoughtworks.examonline.papercontext.adapter.api.query.PaperDetailQuery;
import com.thoughtworks.examonline.papercontext.domain.model.paper.IllegalQuizzesCountException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gitqh
 */
@RestController
@RequestMapping("/papers")
public class PaperController {
    private PaperApplicationService paperApplicationService;

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public PaperDto assemble(@RequestBody final AssemblePaperCommand command)
            throws IllegalQuizzesCountException {
        var paperId = paperApplicationService.assemblePaper(command);
        return PaperDto.from(paperId.toString());
    }

    @GetMapping("/{paperId}/quizzes-detail")
    public PaperDetailDto retrieveDetail(@PathVariable final PaperDetailQuery paperDetailQuery) {
        return PaperDetailDto.from();
    }

    @PutMapping("/{paperId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public PaperDto reassemble(@PathVariable final String paperId,
                               @RequestBody final AssemblePaperCommand command)
            throws IllegalQuizzesCountException {
        var newPaperId = paperApplicationService.reassemblePaper(paperId, command);
        return PaperDto.from(newPaperId.toString());
    }
}
