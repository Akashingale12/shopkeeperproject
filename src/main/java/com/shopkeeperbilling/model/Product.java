package com.shopkeeperbilling.model;

import javax.persistence.*;
import lombok.Data;


@Entity
@Table(name = "product")
@Data
public class
Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long productId;

    @Column(name = "name")
    private String productName;

    @Column(name = "price")
    private long productPrice;


}
