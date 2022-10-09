package org.ersun.model.address;

import lombok.Getter;

@Getter
public enum City {

    ISTANBUL("Istanbul", "IST"),
    ANKARA("Ankara", "ANK"),
    IZMIR("Izmir", "IZ");

    private String value;
    private String shortCode;

    City(String value, String shortCode) {
        this.value = value;
        this.shortCode = shortCode;
    }

}
