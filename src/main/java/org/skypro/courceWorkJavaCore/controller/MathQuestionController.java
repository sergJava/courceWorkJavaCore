package org.skypro.courceWorkJavaCore.controller;

import org.skypro.courceWorkJavaCore.model.Question;
import org.skypro.courceWorkJavaCore.service.impl.MathQuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {
    private final MathQuestionService questionService;

    public MathQuestionController(MathQuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return questionService.remove(new Question(question, answer));
    }

    @GetMapping
    public Collection<Question> getQuestoins() {
        return questionService.getAll();
    }
}
