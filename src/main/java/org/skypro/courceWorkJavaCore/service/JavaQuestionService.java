package org.skypro.courceWorkJavaCore.service;

import org.skypro.courceWorkJavaCore.exceptions.ExistingQuestion;
import org.skypro.courceWorkJavaCore.exceptions.NoSuchQuestionException;
import org.skypro.courceWorkJavaCore.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{
    private final ExaminerServiceImpl examinerServiceImpl;
    private final Random random = new Random();
    private final Set<Question> actualQuestions;


    public JavaQuestionService(ExaminerServiceImpl examinerServiceImpl) {
        this.examinerServiceImpl = examinerServiceImpl;
        actualQuestions = new HashSet<>(examinerServiceImpl.getDefaultQuestions());
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question.trim().toLowerCase(), answer.trim().toLowerCase());
        if (actualQuestions.contains(newQuestion)) {
            throw new ExistingQuestion();
        }
        actualQuestions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        if (actualQuestions.contains(question)) {
            throw new ExistingQuestion();
        }
        actualQuestions.add(question);
        return question;
    }


    @Override
    public Question remove(Question question) {
        if (actualQuestions.contains(question)) {
            actualQuestions.remove(question);
            return question;
        }
        throw new NoSuchQuestionException();
    }

    @Override
    public Collection<Question> getAll() {
        return actualQuestions;
    }

    @Override
    public Question getRandomQuestion() {
        ArrayList<Question> list = new ArrayList<>(actualQuestions);
        Question randomQuestion = list.get(random.nextInt(list.size()));
        return randomQuestion;
    }
}
