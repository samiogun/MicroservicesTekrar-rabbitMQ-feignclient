package org.ersun.model.address;

import lombok.*;
import org.ersun.model.account.Account;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @SequenceGenerator(
            name = "address_id_generator",
            sequenceName = "seq_address",
            allocationSize = 5
    )
    @GeneratedValue(
            generator = "address_id_generator",
            strategy = GenerationType.SEQUENCE
    )
    @Column(
            name = "ID",
            updatable = false,
            nullable = false
    )
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "CITY")
    private City city;

    @Enumerated(EnumType.STRING)
    @Column(name = "DISTRICT")
    private District district;

    @Column(name = "DESC")
    private String desc;

    @Column(name = "ADDRESS_TYPE")
    @Enumerated(EnumType.ORDINAL)
    private AddressType addressType;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;
}
