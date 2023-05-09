package com.shopkeeperbilling.dto;

import lombok.Data;

@Data
public class CustomerResponseDTO {
    private long customerId;
    private String customerName;
    private String customerMobileNumber;
    private String customerAddress;
}
