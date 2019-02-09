package com.dnsc.domain;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * The type Price.
 */
public class Price implements Comparable<Price> {
    private BigDecimal fixedPrice;
    private BigDecimal volumePrice;
    private long volume;

    /**
     * Instantiates a new Price.
     *
     * @param fixedPrice  the fixed price
     * @param volumePrice the volume price
     * @param volume      the volume
     */
    public Price(BigDecimal fixedPrice, BigDecimal volumePrice, long volume) {
        this.fixedPrice = fixedPrice;
        this.volumePrice = volumePrice;
        this.volume = volume;
    }

    @Override
    public int compareTo(Price o) {
        return this.compareTo(o);
    }

    /**
     * Gets fixed price.
     *
     * @return the fixed price
     */
    public BigDecimal getFixedPrice() {
        return fixedPrice;
    }

    /**
     * Gets volume price.
     *
     * @return the volume price
     */
    public BigDecimal getVolumePrice() {
        return volumePrice;
    }

    /**
     * Gets volume.
     *
     * @return the volume
     */
    public long getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "Price{" + "fixedPrice=" + fixedPrice + ", volumePrice=" + volumePrice + ", volume=" + volume + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Price price = (Price) o;
        return Objects.equals(fixedPrice, price.fixedPrice) && Objects.equals(volumePrice, price.volumePrice)
                && Objects.equals(volume, price.volume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fixedPrice, volumePrice, volume);
    }
}
