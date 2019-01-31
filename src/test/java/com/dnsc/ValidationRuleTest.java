package com.dnsc;

import com.dnsc.validation.SldMaxLengthValidatorRule;
import com.dnsc.validation.SldNameValidatorRule;
import com.dnsc.validation.TldValidationRule;
import com.dnsc.validation.ValidationRule;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidationRuleTest {


    @Test
    public void shouldPassTldValidation() {

        ValidationRule rule = new TldValidationRule();
        Assert.assertTrue(rule.isValid("denis.com"));
        Assert.assertTrue(rule.isValid("denis.org"));
        Assert.assertTrue(rule.isValid("denis.info"));
        Assert.assertTrue(rule.isValid("denis.net"));
    }

    @Test
    public void shouldFailTldValidation() {

        ValidationRule rule = new TldValidationRule();
        Assert.assertFalse(rule.isValid("denis.co"));
    }


    @Test
    public void shouldPassSidMaxLenghtValidation() {

        ValidationRule rule = new SldMaxLengthValidatorRule();
        Assert.assertTrue(rule.isValid("denis.com"));
    }

    @Test
    public void shouldFailSidMaxLenghtValidation() {

        ValidationRule rule = new SldMaxLengthValidatorRule();
        Assert.assertFalse(rule.isValid("denisdenisdenisdenisdenisdenisdenisdenisdenisdenisdenisdenisdenisdenisdenisdenisdenisdenisdenisdenisdenisdenisdenisdenis.com"));
    }

    @Test
    public void shouldPassSidNameValidation() {
        ValidationRule rule = new SldNameValidatorRule();
        Assert.assertTrue(rule.isValid("denis-z0ntak.com"));
    }

    @Test
    public void shouldFailSidNameValidation() {
        ValidationRule rule = new SldNameValidatorRule();
        Assert.assertFalse(rule.isValid("denis_z0ntak.com"));
    }

}
