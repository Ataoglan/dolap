package com.example.dolapcase.enums;

public enum UserStatus {
    ACTIVE("ACTIVE"), PASSIVE("PASSIVE"), WAITING_ACTIVATION("WAITING_ACTIVATION");

    private String val;

    UserStatus(final String val){
        this.val = val;
    }

    public String val(){
        return this.val;
    }
}
