package com.shopkeeperbilling.dto;

import lombok.Data;

@Data
public class ResponseEntityDTO {
    int response_code;
    String response_message;
    Object response_body;

    public ResponseEntityDTO(int response_code, String response_message, Object response_body) {
        this.response_code = response_code;
        this.response_message = response_message;
        this.response_body = response_body;
    }
}
