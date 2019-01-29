package com.dnsc.price;

import com.dnsc.domain.DomainType;
import com.dnsc.domain.LineItem;
import com.dnsc.domain.Price;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class InMemoryCalculationEngine implements CalculationEngine {

    @Override
    public BigDecimal calculate(List<LineItem> items) {
        Map<DomainType, List<Price>> domainTypeListMap = extractDomainTypeMap(items);
        BigDecimal total = BigDecimal.valueOf(0).setScale(2, RoundingMode.HALF_EVEN);
        for (DomainType domainType : domainTypeListMap.keySet()) {
            List<Price> prices = domainTypeListMap.get(domainType);
            for (int i = 0; i < prices.size(); i++) {
                Price price = prices.get(i);
                if (price.getVolumePrice() != null && price.getVolume() <= prices.size() - i) {
                    total = total.add(price.getVolumePrice());
                    // jump ahead
                    i = i + price.getVolume() - 1;

                } else {
                    total = total.add(price.getFixedPrice());
                }
            }
        }
        return total;
    }

    private Map<DomainType, List<Price>> extractDomainTypeMap(List<LineItem> items) {
        Map<DomainType, List<Price>> domainTypeListMap = new HashMap<>();

        for (LineItem item : items) {
            Price price = item.getPrice();
            DomainType domainType = item.getDomainType();
            if (domainTypeListMap.containsKey(domainType)) {
                domainTypeListMap.get(domainType).add(price);
            } else {
                List<Price> priceList = new ArrayList<>();
                priceList.add(price);
                domainTypeListMap.put(domainType, priceList);
            }
        }
        return domainTypeListMap;
    }
}
