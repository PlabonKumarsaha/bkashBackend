package com.bikash.bikashBackend.util;

public enum RoleConstraint {
    ROLE_ADMIN("ROLE_ADMIN", "Admin role"),
    ROLE_MERCHANT("ROLE_MERCHANT", "Merchant role"),
    ROLE_USER("ROLE_USER", "User role");
    private String name;
    private String description;

    RoleConstraint(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
