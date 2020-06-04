package com.thoughtworks.examonline.papercontext.adapter.repository.po;

import com.thoughtworks.examonline.common.tech.utils.JsonUtils;
import com.thoughtworks.examonline.papercontext.domain.model.paper.Paper;
import java.io.IOException;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gitqh
 */
@Entity
@Table(name = "paper")
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class PaperPO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String blankQuizzes;

    private String teacherId;

    public static PaperPO from(final Paper paper) {
        try {
            return PaperPO.of(paper.getId().toString(), JsonUtils.toJson(paper.getBlankQuizzes()),
                    paper.getTeacherId());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Paper to(final PaperPO paperPO) {
//        return Paper.of(new PaperId(id), JsonUtils.toClass(), teacherId);
        return null;
    }
}
