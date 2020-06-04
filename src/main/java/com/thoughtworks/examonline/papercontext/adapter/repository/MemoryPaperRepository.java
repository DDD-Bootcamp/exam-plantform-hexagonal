package com.thoughtworks.examonline.papercontext.adapter.repository;

import com.google.common.collect.Sets;
import com.thoughtworks.examonline.papercontext.domain.model.paper.Paper;
import com.thoughtworks.examonline.papercontext.domain.model.paper.PaperId;
import com.thoughtworks.examonline.papercontext.domain.model.paper.PaperRepository;
import java.util.Set;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Repository;

@SuppressWarnings("checkstyle:magicnumber")
@Repository
public class MemoryPaperRepository implements PaperRepository {
    private final Set<Paper> papers = Sets.newHashSet();

    {
        papers.add(Paper.builder()
                .id(new PaperId("Paper001"))
                .teacherId("Teacher001")
                .build());
    }

    @Override
    public void save(final Paper paper) {
        var existed = papers.stream().anyMatch(e -> e.equals(paper));
        if (existed) {
            papers.stream().filter(e -> e.equals(paper)).forEach(
                    o -> {
                        o.setTeacherId(paper.getTeacherId());
                    }
            );
        } else {
            papers.add(paper);
        }
    }

    public void delete(final String id) {
        papers.removeIf(e -> e.getId().getValue().equals(id));
    }

    @Override
    public Paper find(final PaperId id) {
        return papers.stream()
                .filter(paper -> paper.getId().equals(id))
                .findFirst()
                .orElseThrow(EntityNotFoundException::new);
    }

    public Set<Paper> getAll() {
        return papers;
    }

}
