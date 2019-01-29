package com.dnsc;

import com.dnsc.domain.LineItem;

import java.math.BigDecimal;
import java.util.List;

/**
 * A Cart interface for Domain shopping cart
 */
public interface Cart {
    /**
     * Add line item.
     *
     * @param domain the domain
     * @return the line item
     */
    LineItem addItem(String domain);

    /**
     * Gets items in the cart.
     *
     * @return the items
     */
    List<LineItem> getItems();

    /**
     * Calculate cart.
     *
     * @return cart total
     */
    BigDecimal calculate();
}
