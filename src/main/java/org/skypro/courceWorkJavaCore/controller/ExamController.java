package org.skypro.courceWorkJavaCore.controller;

import org.skypro.courceWorkJavaCore.model.Question;
import org.skypro.courceWorkJavaCore.service.ExaminerService;
import org.skypro.courceWorkJavaCore.service.ExaminerServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ExamController {
    private final ExaminerServiceImpl examinerServiceImpl;

    public ExamController(ExaminerServiceImpl examinerServiceImpl) {
        this.examinerServiceImpl = examinerServiceImpl;
    }

    @GetMapping("/exam/get/{amount}")
    public Collection<Question> getQuestion(@PathVariable("amount") int amount) {
        return examinerServiceImpl.getQuestions(amount);
    }
}
