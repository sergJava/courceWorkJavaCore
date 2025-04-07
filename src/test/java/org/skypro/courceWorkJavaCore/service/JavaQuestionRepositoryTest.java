package org.skypro.courceWorkJavaCore.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.courceWorkJavaCore.model.Question;
import org.skypro.courceWorkJavaCore.repository.JavaQuestionRepository;

import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionRepositoryTest {
    JavaQuestionRepository javaQuestionRepository = new JavaQuestionRepository();
    Question question1 = new Question("q1", "a1");
    Question question2 = new Question("q2", "a2");


    @Test
    void add_and_getAll(){
        javaQuestionRepository.add(question1);
        javaQuestionRepository.add(question2);

        Assertions.assertEquals(2, javaQuestionRepository.getAll().size());
        Assertions.assertTrue(javaQuestionRepository.getAll().contains(question1));
        Assertions.assertTrue(javaQuestionRepository.getAll().contains(question2));

    }
    @Test
    void removeTest(){
        Question question1 = new Question("q1", "a1");
        Question question2 = new Question("q2", "a2");
        Set<Question> expectedSet = Set.of(question1, question2);

        javaQuestionRepository.add(question1);
        javaQuestionRepository.add(question2);

        Assertions.assertEquals(2, javaQuestionRepository.getAll().size());
        Assertions.assertTrue(javaQuestionRepository.getAll().contains(question1));

        javaQuestionRepository.remove(question1);

        Assertions.assertEquals(1, javaQuestionRepository.getAll().size());
        Assertions.assertFalse(javaQuestionRepository.getAll().contains(question1));
    }


}
