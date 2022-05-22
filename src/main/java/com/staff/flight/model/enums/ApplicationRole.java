package com.staff.flight.model.enums;

public enum ApplicationRole {
    USER("USER"),
    STAFF("STAFF"),
    ADMIN("ADMIN");

    private static final String ROLE_PREFIX = "ROLE_";
    private final String name;

    ApplicationRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getFullRoleName() {
        return ROLE_PREFIX + name;
    }

}
