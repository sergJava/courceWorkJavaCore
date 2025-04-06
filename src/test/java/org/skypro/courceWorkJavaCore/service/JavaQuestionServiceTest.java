package org.skypro.courceWorkJavaCore.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.courceWorkJavaCore.model.Question;
import org.skypro.courceWorkJavaCore.repository.JavaQuestionRepository;
import org.skypro.courceWorkJavaCore.service.impl.JavaQuestionService;

import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    @Mock
    private Random random;

    @Mock
    private JavaQuestionRepository repository;

    @InjectMocks
    JavaQuestionService javaQuestionService;

    Question question1 = new Question("q1", "a1");
    Question question2 = new Question("q2", "a2");
    Question question3 = new Question("q3", "a3");

    @Test()
    void addTest() {
        Question result = javaQuestionService.add(question1);

        Mockito.verify(repository, Mockito.times(1)).add(question1);
        Assertions.assertEquals(question1, result);
    }

    @Test
    void removeTest() {
        Mockito.when(repository.getAll()).thenReturn(Set.of(question1, question2));

        Question result = javaQuestionService.remove(question1);

        Mockito.verify(repository, Mockito.times(1)).remove(question1);
        Assertions.assertEquals(question1, result);
    }

    @Test
    void getAllTest(){
        javaQuestionService.getAll();
        Mockito.verify(repository, Mockito.times(1)).getAll();
    }

    @Test
    void getRandomQuestionTest() {
        List<Question> mockList = List.of(question1, question2, question3);
        Mockito.when(repository.getAll()).thenReturn(mockList);
        Mockito.when(random.nextInt(anyInt())).thenReturn(2);

        Assertions.assertEquals(question3, javaQuestionService.getRandomQuestion());
    }
}
