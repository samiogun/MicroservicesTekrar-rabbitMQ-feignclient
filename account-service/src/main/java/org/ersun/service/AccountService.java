package org.ersun.service;

import org.ersun.dto.AccountDto;

public interface AccountService {

    AccountDto insertUser(AccountDto accountDto);

    AccountDto getUserById(long id);
}
