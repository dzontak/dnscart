package com.dnsc.price;

import com.dnsc.domain.LineItem;

import java.math.BigDecimal;
import java.util.List;

public interface CalculationEngine {
    BigDecimal calculate(List<LineItem> items);
}
