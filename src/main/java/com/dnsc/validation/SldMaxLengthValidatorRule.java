package com.dnsc.validation;

/**
 * The type Sld max length validator rule.
 */
public class SldMaxLengthValidatorRule extends ValidationRule {

    /**
     * Instantiates a new Sld max length validator rule.
     *
     * @param message the message
     */
    public SldMaxLengthValidatorRule(String message) {
        super(message);
    }

    @Override
    public boolean isValid(String value) {
        final String sld = value.substring(0, value.lastIndexOf("."));
        return sld.length() <= 63;
    }

}
