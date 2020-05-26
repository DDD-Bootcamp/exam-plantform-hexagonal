package com.thoughtworks.examonline.papercontext.adapter.repository;

import com.google.common.collect.Sets;
import com.thoughtworks.examonline.papercontext.domain.model.Paper;
import com.thoughtworks.examonline.papercontext.domain.model.PaperId;
import com.thoughtworks.examonline.papercontext.domain.model.PaperRepository;
import java.time.LocalDateTime;
import java.util.Set;

@SuppressWarnings("checkstyle:magicnumber")
public class MemoryPaperRepository implements PaperRepository {
    private final Set<Paper> papers = Sets.newHashSet();

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
        var existed = papers.stream().anyMatch(e -> e.equals(paper));
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

    @Override
    public Paper find(PaperId id) {
        return papers.stream()
                .filter(paper-> paper.getId().equals(id))
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }

    @Override
    public Set<Paper> getAll() {
        return papers;
    }
}