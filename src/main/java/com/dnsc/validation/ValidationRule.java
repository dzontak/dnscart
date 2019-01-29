package com.dnsc.validation;

public abstract class ValidationRule {

    private String message;

    public ValidationRule(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    abstract public boolean isValid(String value);
}
