package org.skypro.courceWorkJavaCore.service;

import org.skypro.courceWorkJavaCore.model.Question;
import org.springframework.stereotype.Service;
import java.util.Random;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{
    private final Set<Question> questions = new HashSet<>();
    private final Random random;

    public JavaQuestionService(Random random) {
        this.random = random;
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question.trim().toLowerCase(), answer.trim().toLowerCase());
        if (questions.contains(newQuestion)) {
            throw new IllegalArgumentException("такой вопрос уже существует");
        }
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new IllegalArgumentException("такой вопрос уже существует");
        }
        questions.add(question);
        return question;
    }


    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new IllegalArgumentException("такого вопроса нет в списке");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new IllegalStateException("нет доступных вопросов");
        }
        int index = random.nextInt(questions.size());
        return new ArrayList<>(questions).get(index);
    }
}
