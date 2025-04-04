package org.skypro.courceWorkJavaCore.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.courceWorkJavaCore.model.Question;

import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    QuestionService questionService;

    @InjectMocks
    ExaminerServiceImpl examinerService;

    @Test
    void getQuestionsTest() {
        Question question1 = new Question("q1", "a1");
        Question question2 = new Question("q2", "a2");
        Question question3 = new Question("q3", "a3");
        Set<Question> expectedSet = new HashSet<>();
        expectedSet.add(question1);
        expectedSet.add(question2);
        expectedSet.add(question3);

        Mockito.when(questionService.getRandomQuestion()).thenReturn(question1)
                .thenReturn(question2)
                .thenReturn(question3);
        Mockito.when(questionService.getAll()).thenReturn(expectedSet);

        Set<Question> actualSet = (Set<Question>) examinerService.getQuestions(3);
        Assertions.assertEquals(3, actualSet.size());
        Assertions.assertTrue(actualSet.containsAll(expectedSet));
        Assertions.assertTrue(expectedSet.containsAll(actualSet));
    }

    @Test
    void testWithBigAmount() {
        Set<Question> mockSet = Set.of(new Question("q1", "a1")
                , new Question("q2", "a2"));

        Mockito.when(questionService.getAll()).thenReturn(mockSet);
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class
                , () -> examinerService.getQuestions(5));
        Assertions.assertEquals("задайте меньшее количество вопросов", exception.getMessage());
    }
}
