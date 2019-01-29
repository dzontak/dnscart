package com.dnsc.domain;

public enum DomainType {
    COM(".com"), NET(".net"), ORG(".org"), INFO(".info"), UNKNOWN("unknown");

    private final String name;

    DomainType(String name) {
        this.name = name;
    }

    public static DomainType fromName(String name) {
        for (DomainType e : DomainType.values()) {
            if (name.equalsIgnoreCase(e.getName())) {
                return e;
            }
        }
        return UNKNOWN;
    }

    public String getName() {
        return name;
    }

}
