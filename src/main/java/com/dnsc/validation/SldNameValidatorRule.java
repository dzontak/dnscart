package com.dnsc.validation;

import java.util.regex.Pattern;

public class SldNameValidatorRule extends ValidationRule {

    public SldNameValidatorRule(String message) {
        super(message);
    }

    @Override
    public boolean isValid(String value) {
        //A domain's SLD may only include numbers, letters, and dashes
        final String sld = value.substring(0, value.lastIndexOf("."));

        return Pattern.matches("^[a-zA-Z0-9-]+$", sld);
    }
}
