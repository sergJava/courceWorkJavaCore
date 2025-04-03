package org.skypro.courceWorkJavaCore.controller;

import org.skypro.courceWorkJavaCore.exceptions.CourseError;
import org.skypro.courceWorkJavaCore.exceptions.ExistingQuestion;
import org.skypro.courceWorkJavaCore.exceptions.MoreQuestionsRequested;
import org.skypro.courceWorkJavaCore.exceptions.NoSuchQuestionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoSuchQuestionException.class)
    public ResponseEntity<CourseError> handleNoSuchQuestionException(NoSuchQuestionException e) {
        CourseError courseError = new CourseError("QUESTION NOT FOUND", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(courseError);
    }

    @ExceptionHandler(ExistingQuestion.class)
    public ResponseEntity<CourseError> handleExistingQuestionException(ExistingQuestion e) {
        CourseError courseError = new CourseError("QUESTION EXISTS", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(courseError);
    }

    @ExceptionHandler(MoreQuestionsRequested.class)
    public ResponseEntity<CourseError> handleMoreQuestionRequestedException(MoreQuestionsRequested e) {
        CourseError courseError = new CourseError("more questions requested".toUpperCase(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(courseError);
    }
}
