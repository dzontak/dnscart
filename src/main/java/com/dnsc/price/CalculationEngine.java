package com.dnsc.price;

import com.dnsc.domain.LineItem;

import java.math.BigDecimal;
import java.util.List;

/**
 * The interface Calculation engine.
 */
public interface CalculationEngine {
    /**
     * Calculate big decimal.
     *
     * @param items the items
     * @return the big decimal
     */
    BigDecimal calculate(List<LineItem> items);
}
