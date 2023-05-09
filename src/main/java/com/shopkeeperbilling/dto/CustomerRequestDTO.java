package com.shopkeeperbilling.dto;

import lombok.Data;

@Data
public class CustomerRequestDTO {
    private String customerName;
    private String customerMobileNumber;
    private String customerAddress;
}
