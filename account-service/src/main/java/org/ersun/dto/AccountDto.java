package org.ersun.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private long id;
    private String firstname;
    private String lastname;
    private List<AddressDto> addressList;

}
