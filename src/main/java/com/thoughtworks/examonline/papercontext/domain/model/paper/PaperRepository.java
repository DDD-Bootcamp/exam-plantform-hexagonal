package com.thoughtworks.examonline.papercontext.domain.model.paper;

public interface PaperRepository {
    void save(Paper paper);

    Paper find(PaperId id);
}
