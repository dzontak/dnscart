package com.dnsc.validation;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Simple domain validator.
 */
@Component
public class SimpleDomainValidator implements DomainValidator {

    private List<ValidationRule> validationRules = new ArrayList<>();

    /**
     * Instantiates a new Simple domain validator.
     */
    public SimpleDomainValidator() {
        validationRules.add(new TldValidationRule("A domain must include a valid TLD"));
        validationRules.add(new SldMaxLengthValidatorRule("A domain's SLD may only include numbers, letters, and dashes"));
        validationRules.add(new SldMaxLengthValidatorRule("A domain's SLD may only include numbers, letters, and dashes"));
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
