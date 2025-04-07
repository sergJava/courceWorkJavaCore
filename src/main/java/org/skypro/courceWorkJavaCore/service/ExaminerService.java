package org.skypro.courceWorkJavaCore.service;

import org.skypro.courceWorkJavaCore.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
