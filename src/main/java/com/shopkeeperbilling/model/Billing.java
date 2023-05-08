package com.shopkeeperbilling.model;

import javax.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "billing")
@Data
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long billingId;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany
    @Column(name = "product_id")
    private List<Product> product;

    @Column(name = "bill_total")
    private long billingTotal;
}
