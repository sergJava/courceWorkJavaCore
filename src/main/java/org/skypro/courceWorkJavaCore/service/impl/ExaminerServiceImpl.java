package org.skypro.courceWorkJavaCore.service.impl;

import org.skypro.courceWorkJavaCore.model.Question;
import org.skypro.courceWorkJavaCore.service.ExaminerService;
import org.skypro.courceWorkJavaCore.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final List<QuestionService> questionServices;
    private final Random random = new Random();

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService, MathQuestionService mathQuestionService) {
        this.questionServices = List.of(javaQuestionService, mathQuestionService);
    }

    private void checkAmount(int amount) {
        int totalQuestions = questionServices.stream()
                .mapToInt(service -> service.getAll().size())
                .sum();
        if (amount <= 0) {
            throw new IllegalArgumentException("количество вопросов должно быть больше нуля");
        }
        if (amount > totalQuestions) {
            throw new IllegalArgumentException("задайте меньшее количество вопросов");
        }
    }

    private QuestionService getRandomQuestionService() {
        int index = random.nextInt(questionServices.size());
        return questionServices.get(index);
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        checkAmount(amount);

        Set<Question> unickSet = new HashSet<>();
        while (unickSet.size() < amount) {
            QuestionService service = getRandomQuestionService();
            unickSet.add(service.getRandomQuestion());
        }
        return unickSet;
    }
}
