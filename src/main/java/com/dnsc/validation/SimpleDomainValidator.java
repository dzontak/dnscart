package com.dnsc.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Simple domain validator.
 */
@Component
public class SimpleDomainValidator implements DomainValidator {

    private List<ValidationRule> validationRules;

    @Autowired
    public SimpleDomainValidator(List<ValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    @Override
    public boolean validate(String domain) {

        for (ValidationRule rule : validationRules) {
            if (!rule.isValid(domain)) {
                throw new ValidationException(rule);
            }
        }
        return true;
    }
}
