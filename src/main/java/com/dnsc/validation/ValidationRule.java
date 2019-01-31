package com.dnsc.validation;


/**
 * The type Validation rule.
 */
public abstract class ValidationRule {

    private String message;

    /**
     * Instantiates a new Validation rule.
     *
     * @param message the message
     */
    public ValidationRule(String message) {
        this.message = message;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Is valid boolean.
     *
     * @param value the value
     * @return the boolean
     */
    abstract public boolean isValid(String value);
}
