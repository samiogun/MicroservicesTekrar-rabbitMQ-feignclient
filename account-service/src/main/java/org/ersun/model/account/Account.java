package org.ersun.model.account;

import lombok.*;
import org.ersun.model.address.Address;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ACCOUNT")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @SequenceGenerator(
            name = "account_id_generator",
            sequenceName = "seq_account",
            allocationSize = 5
    )
    @GeneratedValue(
            generator = "account_id_generator",
            strategy = GenerationType.SEQUENCE
    )
    @Column(
            name = "ID",
            updatable = false,
            nullable = false
    )
    private long id;

    @Column(name = "FIRST_NAME", length = 50)
    private String firstname;

    @Column(name = "LAST_NAME", length = 50)
    private String lastname;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "account",
            fetch = FetchType.LAZY
    )
    private List<Address> addressList;

}
