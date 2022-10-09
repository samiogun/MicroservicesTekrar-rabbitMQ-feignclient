package org.ersun.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private long id;
    private String city;
    private String district;
    private String addressType;
    private String desc;
    private Long accountId;

}
