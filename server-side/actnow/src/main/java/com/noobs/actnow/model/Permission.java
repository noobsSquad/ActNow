package com.noobs.actnow.model;

//PHONE Permissions when 

public enum Permission {
    ALWAYS_ALLOW("ALWAYS_ALLOW"),
    ONLY_ALLOW_WHILE_USING_APP("ONLY_ALLOW_WHILE_USING_APP"),
    DONT_ALLOW("DONT_ALLOW");

    private final String permission;

    private Permission(String permission) {
        this.permission = permission;
    }

     
}
