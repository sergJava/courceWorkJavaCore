package org.skypro.courceWorkJavaCore.service.impl;

import org.skypro.courceWorkJavaCore.model.Question;
import org.skypro.courceWorkJavaCore.repository.QuestionRepository;
import org.skypro.courceWorkJavaCore.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MathQuestionService implements QuestionService {
    private final QuestionRepository repository;
    private final Random random = new Random();

    @Autowired
    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository repository, Random random) {
        this.repository = repository;
//        this.random = random;
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question.trim().toLowerCase(), answer.trim().toLowerCase());
        if (repository.getAll().contains(newQuestion)) {
            throw new IllegalArgumentException("такой вопрос уже существует");
        }
        repository.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        if (repository.getAll().contains(question)) {
            throw new IllegalArgumentException("такой вопрос уже существует");
        }
        repository.add(question);
        return question;
    }


    @Override
    public Question remove(Question question) {
        if (!repository.getAll().contains(question)) {
            throw new IllegalArgumentException("такого вопроса нет в списке");
        }
        repository.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return repository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Collection<Question> allQuestions = repository.getAll();
        if (allQuestions.isEmpty()) {
            throw new IllegalStateException("нет доступных вопросов");
        }
        int index = random.nextInt(allQuestions.size());
        return new ArrayList<>(allQuestions).get(index);
    }
}
