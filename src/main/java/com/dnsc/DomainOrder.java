package com.dnsc;

import com.dnsc.domain.DomainType;
import com.dnsc.domain.Price;
import com.dnsc.price.CalculationEngine;
import com.dnsc.price.InMemoryCalculationEngine;
import com.dnsc.price.InMemoryPriceEngine;
import com.dnsc.price.PriceEngine;
import com.dnsc.validation.DomainValidator;
import com.dnsc.validation.SimpleDomainValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * The type Domain order.
 */
@Component
public class DomainOrder implements Order {

    private PriceEngine priceEngine;
    private DomainValidator validator;
    private CalculationEngine calculationEngine;

    /**
     * Instantiates a new Domain order.
     *
     * @param priceEngine       the price engine
     * @param validator         the validator
     * @param calculationEngine the calculation engine
     */
    @Autowired
    public DomainOrder(PriceEngine priceEngine, DomainValidator validator, CalculationEngine calculationEngine) {
        this.priceEngine = priceEngine;
        this.validator = validator;
        this.calculationEngine = calculationEngine;
    }

    public Cart newShoppingCart() {
        return new DomainCart(validator, calculationEngine);
    }

    public Price setPrice(DomainType domainType, BigDecimal fixedPrice, BigDecimal volumePrice, int volume) {
        return priceEngine.setPrice(domainType, fixedPrice, volumePrice, volume);
    }

    public Price getPrice(DomainType domainType) {
        return priceEngine.getPrice(domainType);
    }
}
