package com.edgars.carmanage.enums;



public enum FuelType {
    PETROL("petrol"),
    DIESEL("diesel"),
    GAS("gas"),
    ELECTRIC("electric");

    private String fuelType;

    FuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getFuelType() {
        return fuelType;
    }
}
