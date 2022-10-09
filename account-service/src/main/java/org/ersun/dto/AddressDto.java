package org.ersun.dto;

import lombok.*;
import org.ersun.model.address.AddressType;
import org.ersun.model.address.City;
import org.ersun.model.address.District;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private long id;
    private City city;
    private District district;
    private AddressType addressType;
    private String desc;
    private long accountId;

}
