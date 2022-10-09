package org.ersun.service;

import lombok.RequiredArgsConstructor;
import org.ersun.dto.AccountDto;
import org.ersun.model.account.Account;
import org.ersun.model.address.Address;
import org.ersun.repository.AccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    @Override
    public AccountDto insertUser(AccountDto accountDto) {

        List<Address> addresses = new ArrayList<>();

        Account account = Account.builder()
                .firstname(accountDto.getFirstname())
                .lastname(accountDto.getLastname())
                .build();

        accountDto.getAddressList().forEach(
                addressDto -> {
                    addresses.add(
                            Address.builder()
                                    .city(addressDto.getCity())
                                    .district(addressDto.getDistrict())
                                    .desc(addressDto.getDesc())
                                    .addressType(addressDto.getAddressType())
                                    .account(account)
                                    .build()
                    );

                }
        );

        account.setAddressList(addresses);

        return modelMapper.map(
                accountRepository.save(account),
                AccountDto.class
        );
    }

    @Override
    public AccountDto getUserById(long id) {
        return modelMapper.map(
                accountRepository.findById(id).orElseThrow(EntityNotFoundException::new),
                AccountDto.class
        );
    }
}
