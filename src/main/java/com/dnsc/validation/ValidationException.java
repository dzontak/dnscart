package com.dnsc.validation;

public class ValidationException extends RuntimeException {
    private ValidationRule rule;

    public ValidationException(ValidationRule rule) {
        super(rule.getMessage());
        this.rule = rule;
    }

    public ValidationRule getRule() {
        return rule;
    }

    public void setRule(ValidationRule rule) {
        this.rule = rule;
    }
}
