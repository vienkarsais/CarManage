package com.edgars.carmanage.enums;

public enum Gearbox {
    MANUAL("manual"),
    AUTOMATIC("automatic");

    private final String gearbox;

    Gearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public String getGearbox() {
        return gearbox;
    }
}
