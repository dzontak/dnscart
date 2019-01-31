package com.dnsc.price;

import com.dnsc.domain.DomainType;
import com.dnsc.domain.Price;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * The type In memory price engine.
 */
@Component
public class InMemoryPriceEngine implements PriceEngine {

    private Map<DomainType, Price> priceMap = new HashMap<>();

    @Override
    public Price getPrice(DomainType type) {
        return priceMap.get(type);
    }

    @Override
    public Price setPrice(DomainType type, BigDecimal fixedPrice, BigDecimal volumePrice, int volume) {
        return priceMap.put(type, new Price(fixedPrice, volumePrice, volume));
    }
}
