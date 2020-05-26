package com.thoughtworks.examonline.papercontext.domain.model;

import java.util.Set;

public interface PaperRepository {
    void save(Paper paper);

    void delete(String id);

    Paper find(PaperId id);

    Set<Paper> getAll();
}
