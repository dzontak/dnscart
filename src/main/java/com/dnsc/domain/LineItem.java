package com.dnsc.domain;

public class LineItem {

    private String name;
    private DomainType domainType;
    private Price price;

    public LineItem(String name, DomainType domainType, Price price) {
        this.name = name;
        this.domainType = domainType;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DomainType getDomainType() {
        return domainType;
    }

    public void setDomainType(DomainType domainType) {
        this.domainType = domainType;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "LineItem{" +
                "name='" + name + '\'' +
                ", domainType=" + domainType +
                ", price=" + price +
                '}';
    }



}
