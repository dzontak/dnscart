package com.dnsc.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Price implements Comparable<Price> {
    private BigDecimal fixedPrice;
    private BigDecimal volumePrice;
    private int volume;

    public Price(BigDecimal fixedPrice, BigDecimal volumePrice, int volume) {
        this.fixedPrice = fixedPrice;
        this.volumePrice = volumePrice;
        this.volume = volume;
    }

    @Override
    public int compareTo(Price o) {
        return this.compareTo(o);
    }

    public BigDecimal getFixedPrice() {
        return fixedPrice;
    }

    public void setFixedPrice(BigDecimal fixedPrice) {
        this.fixedPrice = fixedPrice;
    }

    public BigDecimal getVolumePrice() {
        return volumePrice;
    }

    public void setVolumePrice(BigDecimal volumePrice) {
        this.volumePrice = volumePrice;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Price{" +
                "fixedPrice=" + fixedPrice +
                ", volumePrice=" + volumePrice +
                ", volume=" + volume +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Objects.equals(fixedPrice, price.fixedPrice) &&
                Objects.equals(volumePrice, price.volumePrice) &&
                Objects.equals(volume, price.volume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fixedPrice, volumePrice, volume);
    }
}
