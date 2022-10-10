package org.ersun.service;

import lombok.RequiredArgsConstructor;
import org.ersun.client.AccountServiceClient;
import org.ersun.dto.OrderDto;
import org.ersun.model.*;
import org.ersun.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final AccountServiceClient accountServiceClient;
    private final ModelMapper modelMapper;
    private final StreamBridge streamBridge;

    @Override
    public OrderDto submitOrder(OrderDto orderDto) {

        ResponseEntity<AccountDto> userDtoResponseEntity = accountServiceClient.getUserById(orderDto.getOwnerId());
        Assert.notNull(userDtoResponseEntity, "Account not found with id : " + orderDto.getOwnerId());
        AccountDto accountDto = userDtoResponseEntity.getBody();

        AddressDto shipmentAddressDto = accountDto
                .getAddressList()
                .stream()
                .filter(addressDto -> addressDto.getAddressType().equalsIgnoreCase(orderDto.getAddressType()))
                .findFirst()
                .get();

        String shipmentAddress = new StringBuilder()
                .append(shipmentAddressDto.getDesc())
                .append(" ")
                .append(shipmentAddressDto.getDistrict())
                .append(" / ")
                .append(shipmentAddressDto.getCity())
                .toString();

        Order order = Order.builder()
                .shipmentAddress(shipmentAddress)
                .ownerId(accountDto.getId())
                .productName(orderDto.getProductName())
                .sku(orderDto.getSku())
                .status(OrderStatus.NEW)
                .build();

        Order orderDb = orderRepository.saveAndFlush(order);

        streamBridge.send("output",
                NotificationDto.builder()
                        .orderId(orderDb.getId())
                        .productName(orderDto.getProductName())
                        .shipmentAddress(shipmentAddress)
                        .build()
        );

        return modelMapper.map(orderDb,OrderDto.class);
    }
}
