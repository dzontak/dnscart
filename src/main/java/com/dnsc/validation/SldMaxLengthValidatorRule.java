package com.dnsc.validation;

public class SldMaxLengthValidatorRule extends ValidationRule {

    public SldMaxLengthValidatorRule(String message) {
        super(message);
    }

    @Override
    public boolean isValid(String value) {
        final String sld = value.substring(0, value.lastIndexOf("."));
        return sld.length() <= 63;
    }

}
