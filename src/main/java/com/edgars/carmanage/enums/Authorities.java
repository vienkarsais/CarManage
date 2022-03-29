package com.edgars.carmanage.enums;

public enum Authorities {
    SHOW_MAIN_PAGE("SHOW_MAIN_PAGE"),
    SHOW_REGISTERED_USERS("SHOW_REGISTERED_USERS");

    private String key;

    Authorities(String key){
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
