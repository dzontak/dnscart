package com.dnsc.validation;

import org.springframework.stereotype.Component;

/**
 * The Validation exception.
 */
public class ValidationException extends RuntimeException {
    private ValidationRule rule;

    /**
     * Instantiates a new Validation exception.
     *
     * @param rule the rule
     */
    public ValidationException(ValidationRule rule) {
        super(rule.getMessage());
        this.rule = rule;
    }

    /**
     * Gets rule.
     *
     * @return the rule
     */
    public ValidationRule getRule() {
        return rule;
    }

    /**
     * Sets rule.
     *
     * @param rule the rule
     */
    public void setRule(ValidationRule rule) {
        this.rule = rule;
    }
}
