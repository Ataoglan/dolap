package com.example.dolapcase.enums;

public enum Role {

    ADMNIN,MEMBER;

    public String authory(){return "ROLE" + this.name();}

}
