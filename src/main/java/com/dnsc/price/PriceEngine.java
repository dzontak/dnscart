package com.dnsc.price;

import com.dnsc.domain.DomainType;
import com.dnsc.domain.Price;

import java.math.BigDecimal;

/**
 * The interface Price engine.
 */
public interface PriceEngine {

    /**
     * A price for a tld
     *
     * @param type A domain type i.e. .com .info .org
     * @return A price for a given domain type.
     */
    Price getPrice(DomainType type);

    /**
     * Sets the price for a TLD
     *
     * @param type        A valid domain type see <code>DomainType</code>
     * @param fixedPrice  A fixed price for tld
     * @param volumePrice A value price for tld ie. 3 for $29.99
     * @param volume      for a Volume price
     * @return A price of a TLD
     */
    Price setPrice(DomainType type, BigDecimal fixedPrice, BigDecimal volumePrice, int volume);
}
