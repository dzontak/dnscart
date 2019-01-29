package com.dnsc;

import com.dnsc.domain.DomainType;
import com.dnsc.domain.Price;

import java.math.BigDecimal;

/**
 * The Domain order api
 */
public interface Order {
    /**
     * New shopping cart.
     *
     * @return the cart
     */
    Cart newShoppingCart();

    /**
     * Sets price
     *
     * @param domainType  the domain type
     * @param fixedPrice  the fixed price
     * @param volumePrice the volume price
     * @param volume      the volume
     * @return the price
     */
    Price setPrice(DomainType domainType, BigDecimal fixedPrice, BigDecimal volumePrice, int volume);

    /**
     * Gets price.
     *
     * @param domainType the domain type
     * @return the price
     */
    Price getPrice(DomainType domainType);
}
