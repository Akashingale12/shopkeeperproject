package com.shopkeeperbilling.dto;

import lombok.Data;

@Data
public class ShopkeeperResponseDto {
    private long shopkeeperId;
    private String shopkeeperName;
    private String shopkeeperEmail;
    private String shopkeeperMobileNumber;
    private String shopkeeperAddress;
}
