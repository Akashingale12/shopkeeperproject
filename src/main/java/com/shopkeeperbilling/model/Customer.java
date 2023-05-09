package com.shopkeeperbilling.model;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String customerName;

    @Column(name = "mobile_number")
    private String customerMobileNumber;

    @Column(name = "address")
    private String customerAddress;
}
