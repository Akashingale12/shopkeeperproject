package com.shopkeeperbilling.dto;

import lombok.Data;

@Data
public class ProductRequestDTO {
    private String productName;
    private long productPrice;
}
