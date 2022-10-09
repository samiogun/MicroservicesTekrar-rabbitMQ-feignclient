package org.ersun.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "\"ORDER\"")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

    @Id
    @SequenceGenerator(
            name = "order_id_generator",
            sequenceName = "seq_order",
            allocationSize = 5
    )
    @GeneratedValue(
            generator = "order_id_generator",
            strategy = GenerationType.SEQUENCE
    )
    private long id;

    @Column(
            name = "PRODUCT_NAME",
            updatable = false,
            nullable = false
    )
    private String productName;

    @Column(
            name = "SKU",
            updatable = false,
            nullable = false
    )
    private long sku;

    @Column(
            name = "OWNER_ID",
            updatable = false,
            nullable = false
    )
    private long ownerId;

    @Column(
            name = "SHIPMENT_ADDRESS",
            nullable = false
    )
    private String shipmentAddress;

    @Column(
            name = "STATUS",
            nullable = false
    )
    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;

}
