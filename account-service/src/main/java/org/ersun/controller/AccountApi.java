package org.ersun.controller;

import lombok.RequiredArgsConstructor;
import org.ersun.dto.AccountDto;
import org.ersun.model.account.Account;
import org.ersun.service.AccountServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountApi {

    private final AccountServiceImpl userService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<AccountDto> createUser(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(userService.insertUser(accountDto),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getUserById(@PathVariable("id") long id){
        return new ResponseEntity<>(
                modelMapper.map(
                        userService.getUserById(id),
                        AccountDto.class
                ),
                HttpStatus.OK
        );
    }

}
