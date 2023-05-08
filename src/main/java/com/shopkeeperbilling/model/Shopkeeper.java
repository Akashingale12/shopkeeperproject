package com.shopkeeperbilling.model;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "shopkeeper")
@Data
public class Shopkeeper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long shopkeeperId;

    @Column(name = "name")
    private String shopkeeperName;

    @Column(name = "email")
    private String shopkeeperEmail;

    @Column(name = "mobile_number")
    private String shopkeeperMobileNumber;

    @Column(name = "address")
    private String shopkeeperAddress;
}
