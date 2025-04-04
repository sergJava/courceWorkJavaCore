package org.skypro.courceWorkJavaCore.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.courceWorkJavaCore.model.Question;

import java.util.Random;

import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    @Mock
    private Random random;

    @InjectMocks
    JavaQuestionService javaQuestionService;

    @Test()
    void add_and_getAll() {
        Question question1 = new Question("q1", "a1");
        Question question2 = new Question("q2", "a2");

        javaQuestionService.add(question1);
        javaQuestionService.add(question2);

        Assertions.assertEquals(2, javaQuestionService.getAll().size());
        Assertions.assertTrue(javaQuestionService.getAll().contains(question1));
        Assertions.assertTrue(javaQuestionService.getAll().contains(question2));

    }

    @Test
    void add_negativeResult() {
        Question question1 = new Question("q1", "a1");
        javaQuestionService.add(question1);

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class
                , () -> javaQuestionService.add(question1));
        Assertions.assertEquals("такой вопрос уже существует", exception.getMessage());
    }

    @Test
    void removeTest() {
        Question question = javaQuestionService.add(new Question("q1", "a1"));
        javaQuestionService.remove(question);

        Assertions.assertEquals(0, javaQuestionService.getAll().size());
        Assertions.assertTrue(!javaQuestionService.getAll().contains(question));
    }

    @Test
    void getRandomQuestionTest() {
        Question question1 = javaQuestionService.add(new Question("q1", "a1"));
        Question question2 = javaQuestionService.add(new Question("q2", "a2"));
        Question question3 = javaQuestionService.add(new Question("q3", "a3"));

        Mockito.when(random.nextInt(anyInt())).thenReturn(2);

        Assertions.assertEquals(question3, javaQuestionService.getRandomQuestion());
    }
}
