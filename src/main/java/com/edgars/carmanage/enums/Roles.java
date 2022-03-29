package com.edgars.carmanage.enums;

public enum Roles {
    EMPLOYEE("EMPLOYEE"),
    MANAGER("MANAGER"),
    ADMIN("ADMIN");


    private String key;

    Roles(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public String getAuthority(){
        return getKey();
    }


}
