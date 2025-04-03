package org.skypro.courceWorkJavaCore.service;

import org.skypro.courceWorkJavaCore.exceptions.MoreQuestionsRequested;
import org.skypro.courceWorkJavaCore.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    Set<Question> defaultQuestions;

    public ExaminerServiceImpl() {
        this.defaultQuestions = new HashSet<>();
        initializeDefaultQuestions();
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > defaultQuestions.size()) {
            throw new MoreQuestionsRequested();
        }
        return defaultQuestions
                .stream()
                .limit(amount)
                .collect(Collectors.toSet());
    }

    public void initializeDefaultQuestions() {
        defaultQuestions.add(new Question("лучший язык программирования", "java"));
        defaultQuestions.add(new Question("лучшая онлайн школа", "skypro"));
        defaultQuestions.add(new Question("лучший фреймворк", "spring boot"));
    }

    public Collection<Question> getDefaultQuestions(){
        return Collections.unmodifiableSet(defaultQuestions);
    }
}
