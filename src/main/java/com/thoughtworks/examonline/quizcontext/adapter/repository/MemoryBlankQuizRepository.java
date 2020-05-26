package com.thoughtworks.examonline.quizcontext.adapter.repository;

import com.google.common.collect.Sets;
import com.thoughtworks.examonline.quizcontext.domain.blankquiz.BlankQuiz;
import com.thoughtworks.examonline.quizcontext.domain.blankquiz.BlankQuizId;
import com.thoughtworks.examonline.quizcontext.domain.blankquiz.BlankQuizRepository;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author gitqh
 */
@SuppressWarnings("checkstyle:magicnumber")
public class MemoryBlankQuizRepository implements BlankQuizRepository {
    private final Set<BlankQuiz> blankQuizzes = Sets.newHashSet();

    {
        blankQuizzes.add(BlankQuiz.builder()
                .id(new BlankQuizId("BlankQuiz001"))
                .teacherId("Teacher001")
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build());
    }

    @Override
    public void save(final BlankQuiz blankQuiz) {
        boolean existed = blankQuizzes.stream().anyMatch(e -> e.equals(blankQuiz));
        if (existed) {
            blankQuizzes.stream().filter(e -> e.equals(blankQuiz)).forEach(
                    o -> {
                        o.setTeacherId(blankQuiz.getTeacherId());
                        o.setUpdateTime(LocalDateTime.now());
                    }
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
    public BlankQuiz find(BlankQuizId blankQuizId) {
        return blankQuizzes.stream()
                .filter(quiz -> quiz.getId().equals(blankQuizId))
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }
}
