package com.dnsc.validation;

import org.springframework.stereotype.Component;

/**
 * The type Sld max length validator rule.
 */
@Component
public class SldMaxLengthValidatorRule extends ValidationRule {

    /**
     * Instantiates a new Sld max length validator rule.
     *
     */
    public SldMaxLengthValidatorRule() {
        super("A domain's SLD may have no more than 63 characters");
    }

    @Override
    public boolean isValid(String value) {
        final String sld = value.substring(0, value.lastIndexOf("."));
        return sld.length() <= 63;
    }

}
