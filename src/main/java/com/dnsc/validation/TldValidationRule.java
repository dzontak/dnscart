package com.dnsc.validation;

import com.dnsc.domain.DomainType;

public class TldValidationRule extends ValidationRule {

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
