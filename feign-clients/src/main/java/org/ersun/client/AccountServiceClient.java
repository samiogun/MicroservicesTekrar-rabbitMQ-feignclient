package org.ersun.client;

import org.ersun.config.FeignClientConfig;
import org.ersun.model.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        value = "account-service",
        configuration = FeignClientConfig.class
)
public interface AccountServiceClient {

    @GetMapping(value = "accounts/{id}", produces = "application/json")
    ResponseEntity<AccountDto> getUserById(@PathVariable("id") long id);

}
