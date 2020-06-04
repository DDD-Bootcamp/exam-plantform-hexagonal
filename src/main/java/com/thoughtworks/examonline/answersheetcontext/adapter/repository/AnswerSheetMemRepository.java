package com.thoughtworks.examonline.answersheetcontext.adapter.repository;

import com.google.common.collect.Sets;
import com.thoughtworks.examonline.answersheetcontext.domain.model.answersheet.AnswerSheet;
import com.thoughtworks.examonline.answersheetcontext.domain.model.answersheet.AnswerSheetId;
import com.thoughtworks.examonline.answersheetcontext.domain.model.answersheet.AnswerSheetRepository;
import java.util.Set;
import org.springframework.stereotype.Repository;

/**
 * @author gitqh
 */
@SuppressWarnings("checkstyle:magicnumber")
@Repository
public class AnswerSheetMemRepository implements AnswerSheetRepository {
    private final Set<AnswerSheet> answerSheets = Sets.newHashSet();

    {
        answerSheets.add(AnswerSheet.builder()
                .id(new AnswerSheetId("answersheet-001"))
                .score(0)
                .studentId("student-001")
                .build());
    }

    @Override
    public void save(final AnswerSheet answerSheet) {
        var existed = answerSheets.stream().anyMatch(e -> e.equals(answerSheet));
        if (existed) {
            answerSheets.stream().filter(e -> e.equals(answerSheet)).forEach(
                    o -> {
                        o.setId(answerSheet.getId());
                        o.setScore(answerSheet.getScore());
                        o.setStudentId(answerSheet.getStudentId());
                    }
            );
        } else {
            answerSheets.add(answerSheet);
        }
    }

    @Override
    public AnswerSheet findById(final AnswerSheetId id) {
        return null;
    }
}
