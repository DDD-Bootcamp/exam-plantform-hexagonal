package com.thoughtworks.examonline.papercontext.adapter.api;

import com.google.common.collect.Lists;
import com.thoughtworks.examonline.papercontext.application.AssemblePaperCommand;
import com.thoughtworks.examonline.papercontext.application.PaperApplicationService;
import com.thoughtworks.examonline.papercontext.domain.model.Paper;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gitqh
 */
@RestController
public class PaperController {
    private PaperApplicationService paperApplicationService;

    @PostMapping("/papers")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public PaperDto assemble(@RequestBody AssemblePaperCommand command) {
        var paperId = paperApplicationService.assemblePaper(command);
        return PaperDto.from(paperId.toString());
    }

    @GetMapping("/papers")
    public List<Paper> getAll() {
        return Lists.newArrayList(paperApplicationService.getAll());
    }

    @PutMapping("/papers/{paperId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public PaperDto reassemble(@PathVariable String paperId, @RequestBody AssemblePaperCommand command) {
        var newPaperId = paperApplicationService.reassemblePaper(paperId, command);
        return PaperDto.from(newPaperId.toString());
    }
}
