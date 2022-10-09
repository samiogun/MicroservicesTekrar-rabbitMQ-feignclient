package org.ersun.service;

import org.ersun.dto.AddressDto;
import org.ersun.model.address.Address;

import java.util.List;

public interface AddressService {

    Address inserAddress(AddressDto addressDto);

    List<Address> insertAddresses(List<AddressDto> addressDtoList);

}
