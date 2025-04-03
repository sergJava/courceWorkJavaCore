package org.skypro.courceWorkJavaCore.exceptions;

public class CourseError {
    private final String code;
    private final String message;

    public CourseError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
