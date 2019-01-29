package com.dnsc;

import com.dnsc.domain.DomainType;
import com.dnsc.domain.Price;
import com.dnsc.price.CalculationEngine;
import com.dnsc.price.InMemoryCalculationEngine;
import com.dnsc.price.InMemoryPriceEngine;
import com.dnsc.price.PriceEngine;
import com.dnsc.validation.DomainValidator;
import com.dnsc.validation.SimpleDomainValidator;

import java.math.BigDecimal;

public class DomainOrder implements Order {

    private PriceEngine priceEngine;
    private DomainValidator validator;
    private CalculationEngine calculationEngine;

    public DomainOrder() {
        priceEngine = new InMemoryPriceEngine();
        validator = new SimpleDomainValidator();
        calculationEngine = new InMemoryCalculationEngine();
    }

    public DomainOrder(PriceEngine priceEngine, DomainValidator validator,
                       CalculationEngine calculationEngine) {
        this.priceEngine = priceEngine;
        this.validator = validator;
        this.calculationEngine = calculationEngine;
    }

    public Cart newShoppingCart() {
        return new DomainCart(priceEngine, validator, calculationEngine);
    }

    public Price setPrice(DomainType domainType, BigDecimal fixedPrice, BigDecimal volumePrice, int volume) {
        return priceEngine.setPrice(domainType, fixedPrice, volumePrice, volume);
    }

    public Price getPrice(DomainType domainType) {
        return priceEngine.getPrice(domainType);
    }
}
