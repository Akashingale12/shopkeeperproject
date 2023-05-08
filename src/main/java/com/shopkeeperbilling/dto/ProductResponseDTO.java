package com.shopkeeperbilling.dto;

import lombok.Data;

@Data
public class ProductResponseDTO {
    private long productId;
    private String productName;
    private long productPrice;
}
