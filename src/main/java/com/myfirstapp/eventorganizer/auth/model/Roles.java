package com.myfirstapp.eventorganizer.auth.model;

public enum Roles {
    USER, ADMIN;

    public static Roles valueOf(int role_id) {
        return role_id == 1 ? USER : ADMIN;
    }
}
