package com.thoughtworks.examonline.papercontext.adapter.repository;

import com.thoughtworks.examonline.papercontext.adapter.repository.po.PaperPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author gitqh
 */
@Repository
public interface JPAPaperRepository extends JpaRepository<PaperPO, String> {
}
