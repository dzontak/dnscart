package com.dnsc.domain;

/**
 * The type Line item.
 */
public class LineItem {

    private String name;
    private DomainType domainType;

    /**
     * Instantiates a new Line item.
     *
     * @param name       the name
     * @param domainType the domain type
     * @param price      the price
     */
    public LineItem(String name, DomainType domainType) {
        this.name = name;
        this.domainType = domainType;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets domain type.
     *
     * @return the domain type
     */
    public DomainType getDomainType() {
        return domainType;
    }

    @Override
    public String toString() {
        return "LineItem{" + "name='" + name + '\'' + ", domainType=" + domainType + '}';
    }

}
