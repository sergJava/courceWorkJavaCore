package org.skypro.courceWorkJavaCore.repository;

import org.skypro.courceWorkJavaCore.model.Question;

import java.util.Collection;

public interface QuestionRepository {
    void add(Question question);

    void remove(Question question);

    Collection<Question> getAll();
}
