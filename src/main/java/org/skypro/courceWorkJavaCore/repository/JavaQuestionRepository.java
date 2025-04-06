package org.skypro.courceWorkJavaCore.repository;

import org.skypro.courceWorkJavaCore.model.Question;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("javaQuestionRepository")
public class JavaQuestionRepository implements QuestionRepository {
    Set<Question> questions = new HashSet<>();

    @Override
    public void add(Question question) {
        questions.add(question);
    }

    @Override
    public void remove(Question question) {
        questions.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }
}
