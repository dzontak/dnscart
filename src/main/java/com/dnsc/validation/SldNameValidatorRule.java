package com.dnsc.validation;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

/**
 * The type Sld name validator rule.
 */
@Component
public class SldNameValidatorRule extends ValidationRule {

    /**
     * Instantiates a new Sld name validator rule.
     *
     */
    public SldNameValidatorRule() {
        super("A domain's SLD may only include numbers, letters, and dashes");
    }

    @Override
    public boolean isValid(String value) {
        //A domain's SLD may only include numbers, letters, and dashes
        final String sld = value.substring(0, value.lastIndexOf("."));

        return Pattern.matches("^[a-zA-Z0-9-]+$", sld);
    }
}
