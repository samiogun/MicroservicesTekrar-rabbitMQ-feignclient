package org.ersun.controller;

import lombok.RequiredArgsConstructor;
import org.ersun.dto.OrderDto;
import org.ersun.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDto> submitOrder(@RequestBody OrderDto orderDto) {
        return new ResponseEntity<>(orderService.submitOrder(orderDto), HttpStatus.OK);
    }

}
