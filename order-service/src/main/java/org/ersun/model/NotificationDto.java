package org.ersun.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class NotificationDto {

    private long orderId;
    private String productName;
    private String shipmentAddress;

}
