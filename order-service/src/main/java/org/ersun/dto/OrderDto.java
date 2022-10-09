package org.ersun.dto;

import lombok.*;
import org.ersun.model.OrderStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {

    private long id;
    private String productName;
    private long sku;
    private long ownerId;
    private String addressType;
    private OrderStatus status;

}
