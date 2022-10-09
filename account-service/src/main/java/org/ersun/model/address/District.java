package org.ersun.model.address;

import lombok.Getter;

@Getter
public enum District {

    KARTAL("Kartal", "KRTL", "IST"),
    KUCUKCEKMECE("Kucukcekmece", "KCKCKMC","IST"),
    KIZILAY("Kizilay", "KZLY","ANK"),
    MERKEZ("Merkez","MRKZ","ANK"),
    BUCA("Buca","BUC","IZ"),
    KARSIYAKA("Karsiyaka","KRSYK","IZ");

    private String value;
    private String shortCode;
    private String ownerCityCode;


    District(String value, String shortCode, String ownerCityCode) {
        this.value = value;
        this.shortCode = shortCode;
        this.ownerCityCode = ownerCityCode;
    }

}
