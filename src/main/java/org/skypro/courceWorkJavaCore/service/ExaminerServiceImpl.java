package org.skypro.courceWorkJavaCore.service;

import org.skypro.courceWorkJavaCore.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("количество вопросов должно быть больше нуля");
        }
        if (amount > questionService.getAll().size()) {
            throw new IllegalArgumentException("задайте меньшее количество вопросов");
        }

        Set<Question> unickSet = new HashSet<>();
        while (unickSet.size() < amount) {
            unickSet.add(questionService.getRandomQuestion());
        }
        return unickSet;
    }
}
