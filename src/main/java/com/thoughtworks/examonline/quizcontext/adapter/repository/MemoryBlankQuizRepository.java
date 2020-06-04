package com.thoughtworks.examonline.quizcontext.adapter.repository;

import com.google.common.collect.Sets;
import com.thoughtworks.examonline.quizcontext.domain.model.blankquiz.BlankQuiz;
import com.thoughtworks.examonline.quizcontext.domain.model.blankquiz.BlankQuizId;
import com.thoughtworks.examonline.quizcontext.domain.model.blankquiz.BlankQuizRepository;
import java.util.Set;
import org.springframework.stereotype.Repository;

/**
 * @author gitqh
 */
@SuppressWarnings("checkstyle:magicnumber")
@Repository
public class MemoryBlankQuizRepository implements BlankQuizRepository {
    private final Set<BlankQuiz> blankQuizzes = Sets.newHashSet();

    {
        blankQuizzes.add(BlankQuiz.builder()
                .id(new BlankQuizId("BlankQuiz001"))
                .teacherId("Teacher001")
                .build());
    }

    @Override
    public void save(final BlankQuiz blankQuiz) {
        boolean existed = blankQuizzes.stream().anyMatch(e -> e.equals(blankQuiz));
        if (existed) {
            blankQuizzes.stream().filter(e -> e.equals(blankQuiz)).forEach(
                    o -> o.setTeacherId(blankQuiz.getTeacherId())
            );
        } else {
            blankQuizzes.add(blankQuiz);
        }
    }

    @Override
    public void delete(final BlankQuizId id) {
        blankQuizzes.removeIf(e -> e.getId().equals(id));
    }

    @Override
    public BlankQuiz find(final BlankQuizId blankQuizId) {
        return blankQuizzes.stream()
                .filter(quiz -> quiz.getId().equals(blankQuizId))
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }
}
