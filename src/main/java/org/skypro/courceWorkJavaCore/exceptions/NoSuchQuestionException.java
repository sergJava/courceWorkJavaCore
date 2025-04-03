package org.skypro.courceWorkJavaCore.exceptions;

public class NoSuchQuestionException extends RuntimeException {
    public NoSuchQuestionException() {
        super("такой пары вопрос - ответ нет.");
    }

    public NoSuchQuestionException(String message) {
        super(message);
    }
}
