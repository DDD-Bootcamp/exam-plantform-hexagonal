package com.thoughtworks.examonline.papercontext.adapter.repository;

import com.thoughtworks.examonline.papercontext.adapter.repository.po.PaperPO;
import com.thoughtworks.examonline.papercontext.domain.model.paper.Paper;
import com.thoughtworks.examonline.papercontext.domain.model.paper.PaperId;
import com.thoughtworks.examonline.papercontext.domain.model.paper.PaperRepository;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author gitqh
 */
@Component
@AllArgsConstructor
public class PaperRepositoryImpl implements PaperRepository {
    private final JPAPaperRepository jpaPaperRepository;

    @Override
    public void save(final Paper paper) {
        PaperPO paperPO = PaperPO.from(paper);
        Optional.ofNullable(paperPO).ifPresent(jpaPaperRepository::save);
    }

    @Override
    public Paper find(final PaperId id) {
        return jpaPaperRepository.findById(id.toString())
                .map(PaperPO::to).orElseThrow(EntityNotFoundException::new);
    }
}
