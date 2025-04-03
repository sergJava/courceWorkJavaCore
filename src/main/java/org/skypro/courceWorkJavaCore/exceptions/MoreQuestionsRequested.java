package org.skypro.courceWorkJavaCore.exceptions;

public class MoreQuestionsRequested extends RuntimeException {
    public MoreQuestionsRequested() {
        super("запросите меньшее количество вопросов");
    }

    public MoreQuestionsRequested(String message) {
        super(message);
    }
}
