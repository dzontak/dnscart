package com.dnsc.price;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.dnsc.domain.DomainType;
import com.dnsc.domain.LineItem;
import com.dnsc.domain.Price;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * The type In memory calculation engine.
 */
@Slf4j
@Component
public class InMemoryCalculationEngine implements CalculationEngine {
    private PriceEngine priceEngine;

    @Autowired
    public InMemoryCalculationEngine(PriceEngine priceEngine) {
        this.priceEngine = priceEngine;
    }

    @Override
    public BigDecimal calculate(List<LineItem> items) {
        BigDecimal total = BigDecimal.valueOf(0).setScale(2, RoundingMode.HALF_EVEN);
        Map<DomainType, Long> domainTypeToCount = extractDomainTypeMap(items);

        for (DomainType domainType : domainTypeToCount.keySet()) {
            long count = domainTypeToCount.get(domainType);
            Price price = this.priceEngine.getPrice(domainType);
            long discountVolume = price.getVolume();
            if (discountVolume > 0 && count >= discountVolume) {
                long multiplier = count / discountVolume;
                total = total.add(price.getVolumePrice().multiply(BigDecimal.valueOf(multiplier)));

                long remainder = count % discountVolume;
                if (remainder > 0) {
                    total = total.add(price.getFixedPrice().multiply(BigDecimal.valueOf(remainder)));
                }
            } else {
                total = total.add(price.getFixedPrice().multiply(BigDecimal.valueOf(count)));
            }
        }
        return total;
    }

    private Map<DomainType, Long> extractDomainTypeMap(List<LineItem> items) {

        return items.stream().collect(Collectors.groupingBy(LineItem::getDomainType, Collectors.counting()));
    }
}
