package org.skypro.courceWorkJavaCore.service;

import org.skypro.courceWorkJavaCore.model.Question;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class JavaQuestionService {
    private final QuestionService questionService;

    public JavaQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    private Set<Question> questions;

    public Question add(String question, String answer) {
        Question newQuestion = new Question(question.trim(), answer.trim());
        questions.add(newQuestion);
        return newQuestion;
    }

    public Question remove (String question, String answer) {

        return newQuestion;
    }


}
