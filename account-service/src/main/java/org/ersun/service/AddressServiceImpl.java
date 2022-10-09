package org.ersun.service;

import lombok.RequiredArgsConstructor;
import org.ersun.dto.AddressDto;
import org.ersun.model.account.Account;
import org.ersun.model.address.Address;
import org.ersun.repository.AddressRepository;
import org.ersun.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AccountRepository accountRepository;

    @Override
    public Address inserAddress(AddressDto addressDto) {

        Account accountDb = accountRepository.findById(addressDto.getAccountId()).orElseThrow(RuntimeException::new);

        return addressRepository.save(
                Address.builder()
                        .city(addressDto.getCity())
                        .district(addressDto.getDistrict())
                        .desc(addressDto.getDesc())
                        .addressType(addressDto.getAddressType())
                        .account(accountDb)
                        .build()
        );

    }

    @Override
    public List<Address> insertAddresses(List<AddressDto> addressDtoList) {



        List<Address> addresses = new ArrayList<>();

        addressDtoList.forEach(
                addressDto -> {

                    Account accountDb = accountRepository.findById(addressDto.getAccountId()).orElseThrow(RuntimeException::new);

                    addresses.add(
                            new Address(
                                    addressDto.getId(),
                                    addressDto.getCity(),
                                    addressDto.getDistrict(),
                                    addressDto.getDesc(),
                                    addressDto.getAddressType(),
                                    accountDb
                            )
                    );

                }
        );

        return addressRepository.saveAll(addresses);
    }
}
