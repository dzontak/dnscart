package com.dnsc.domain;

/**
 * The enum Domain type.
 */
public enum DomainType {
    /**
     * Com domain type.
     */
    COM(".com"),
    /**
     * Net domain type.
     */
    NET(".net"),
    /**
     * Org domain type.
     */
    ORG(".org"),
    /**
     * Info domain type.
     */
    INFO(".info"),
    /**
     * Unknown domain type.
     */
    UNKNOWN("unknown");

    private final String name;

    DomainType(String name) {
        this.name = name;
    }

    /**
     * From name domain type.
     *
     * @param name the name
     * @return the domain type
     */
    public static DomainType fromName(String name) {
        for (DomainType e : DomainType.values()) {
            if (name.equalsIgnoreCase(e.getName())) {
                return e;
            }
        }
        return UNKNOWN;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

}
