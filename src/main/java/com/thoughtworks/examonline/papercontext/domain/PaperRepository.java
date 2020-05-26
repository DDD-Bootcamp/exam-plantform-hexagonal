package com.thoughtworks.examonline.papercontext.domain;

public interface PaperRepository {
    void save(Paper paper);

    void delete(String id);
}
