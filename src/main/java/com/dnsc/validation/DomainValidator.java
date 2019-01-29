package com.dnsc.validation;

/**
 * The interface Domain validator.
 */
public interface DomainValidator {

    /**
     * Validate a rule.
     *
     * @param domain the domain
     * @return the true or false if the rule fails
     * @throws ValidationException if the domain is not valid. note that the ValidationRule
     * that failed is included in the <code>ValidationException</code>
     */
    boolean validate(String domain);
}
