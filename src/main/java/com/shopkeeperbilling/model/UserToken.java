package com.shopkeeperbilling.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_token")
@Data
public class UserToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "token")
    private String token;

    @ManyToOne
    @JoinColumn(name = "sid")
    private Shopkeeper shopkeeper;

    @Column(name= "created_at")
    private Date createdAt;

}
