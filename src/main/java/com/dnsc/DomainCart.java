package com.dnsc;

import com.dnsc.domain.DomainType;
import com.dnsc.domain.LineItem;
import com.dnsc.price.CalculationEngine;
import com.dnsc.price.PriceEngine;
import com.dnsc.validation.DomainValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Domain cart.
 */
@Component
public class DomainCart implements Cart {

    private CalculationEngine calculationEngine;
    private DomainValidator validator;
    private List<LineItem> lineItems = new ArrayList<>();

    /**
     * Instantiates a new Domain cart.
     *
     * @param priceEngine       the price engine
     * @param validator         the validator
     * @param calculationEngine the calculation engine
     */
    @Autowired
    public DomainCart(DomainValidator validator, CalculationEngine calculationEngine) {
        this.validator = validator;
        this.calculationEngine = calculationEngine;
    }

    /**
     * Adds a domain name to a cart
     *
     * @param domain a valid domain name
     * @throws IllegalArgumentException will be thrown if the domain name is not
     *                                  valid.
     */
    public LineItem addItem(String domain) {
        boolean isValid = validator.validate(domain);
        if (!isValid) {
            throw new IllegalArgumentException("invalid domain");
        }
        return addLineItem(domain);
    }

    private LineItem addLineItem(String domain) {
        String tld = domain.substring(domain.lastIndexOf("."));
        DomainType domainType = DomainType.fromName(tld);
        LineItem lineItem = new LineItem(domain, domainType);
        this.lineItems.add(lineItem);
        return lineItem;
    }

    public List<LineItem> getItems() {
        return this.lineItems;
    }

    public BigDecimal calculate() {
        return this.calculationEngine.calculate(this.getItems());
    }
}
