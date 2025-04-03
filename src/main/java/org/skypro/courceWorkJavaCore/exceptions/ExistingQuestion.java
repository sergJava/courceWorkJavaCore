package org.skypro.courceWorkJavaCore.exceptions;

public class ExistingQuestion extends RuntimeException {
    public ExistingQuestion() {
        super("такой вопрос уже существует");
    }

    public ExistingQuestion(String message) {
        super(message);
    }
}
