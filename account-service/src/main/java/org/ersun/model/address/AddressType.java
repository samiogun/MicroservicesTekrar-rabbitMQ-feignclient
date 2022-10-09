package org.ersun.model.address;

public enum AddressType {

    WORK("Work"),
    HOME("Home"),
    OTHER("Other");

    private String desc;

    AddressType(String desc){
        this.desc = desc;
    }

}
