package com.iralus.inventory.entity;

public enum Status {
    ACTIVE("ACTIVE") ,
    INACTIVE("INACTIVE");

    private String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatusAsString() {
        return status;
    }
}
