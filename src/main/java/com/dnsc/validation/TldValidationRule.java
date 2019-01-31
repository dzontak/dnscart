package com.dnsc.validation;

import com.dnsc.domain.DomainType;
import org.springframework.stereotype.Component;

/**
 * The type Tld validation rule.
 */
@Component
public class TldValidationRule extends ValidationRule {

    /**
     * Instantiates a new Tld validation rule.
     *
     */
    public TldValidationRule() {
        super("A domain must include a valid TLD");
    }

    @Override
    public boolean isValid(String value) {
        // A domain must include a valid TLD
        final String tld = value.substring(value.lastIndexOf("."));
        return !DomainType.fromName(tld).equals(DomainType.UNKNOWN);
    }

}
