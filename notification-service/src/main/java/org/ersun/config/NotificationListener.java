package org.ersun.config;

import lombok.RequiredArgsConstructor;
import org.ersun.client.AccountServiceClient;
import org.ersun.model.NotificationDto;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@EnableFeignClients(basePackages = "org.ersun.client")
@RequiredArgsConstructor
public class NotificationListener {

    @Bean
    public Consumer<NotificationDto> sendNotification() {
        return notificationDto -> {

            System.out.println("Order ID : " + notificationDto.getOrderId());
            System.out.println("Ordered Product : " + notificationDto.getProductName());
            System.out.println("Shipment Address : " + notificationDto.getShipmentAddress());

        };
    }

}
