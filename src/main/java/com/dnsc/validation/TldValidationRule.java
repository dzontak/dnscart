package com.dnsc.validation;

import com.dnsc.domain.DomainType;
import org.springframework.stereotype.Component;

/**
 * The type Tld validation rule.
 */
public class TldValidationRule extends ValidationRule {

    /**
     * Instantiates a new Tld validation rule.
     *
     * @param message description of the validation
     */
    public TldValidationRule(String message) {
        super(message);
    }

    @Override
    public boolean isValid(String value) {
        // A domain must include a valid TLD
        final String tld = value.substring(value.lastIndexOf("."));
        return !DomainType.fromName(tld).equals(DomainType.UNKNOWN);
    }

}
