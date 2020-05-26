package com.thoughtworks.examonline.papercontext.adapter.repository;

import com.google.common.collect.Sets;
import com.thoughtworks.examonline.papercontext.domain.Paper;
import com.thoughtworks.examonline.papercontext.domain.PaperId;
import com.thoughtworks.examonline.papercontext.domain.PaperRepository;
import java.time.LocalDateTime;
import java.util.Set;

@SuppressWarnings("checkstyle:magicnumber")
public class PaperMemRepository implements PaperRepository {
    private Set<Paper> papers = Sets.newHashSet();

    {
        papers.add(Paper.builder()
                .id(new PaperId("Paper001"))
                .teacherId("Teacher001")
                .assembleTime(LocalDateTime.now())
                .reassembleTime(LocalDateTime.now())
                .build());
    }

    @Override
    public void save(final Paper paper) {
        boolean existed = papers.stream().anyMatch(e -> e.equals(paper));
        if (existed) {
            papers.stream().filter(e -> e.equals(paper)).forEach(
                    o -> {
                        o.setTeacherId(paper.getTeacherId());
                        o.setAssembleTime(LocalDateTime.now());
                    }
            );
        } else {
            papers.add(paper);
        }
    }

    @Override
    public void delete(final String id) {
        papers.removeIf(e -> e.getId().getValue().equals(id));
    }
}