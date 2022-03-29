package com.edgars.carmanage.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


public enum Roles {
    EMPLOYEE("EMPLOYEE"),
    MANAGER("MANAGER"),
    ADMIN("ADMIN");

    private static String prefix = "ROLE_";
    private String key;

    Roles(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public String getAuthority(){
        return prefix+getKey();
    }


}
