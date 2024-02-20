package com.example.demo;

public enum Role {
    USER("USER"),
    NO_WAIT_PATIENT("NO_WAIT_PATIENT"),
    WAIT_PATIENT("WAIT_PATIENT"),
    ADMIN("ADMIN");

    private final String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRole() {
        return roleName;
    }
}