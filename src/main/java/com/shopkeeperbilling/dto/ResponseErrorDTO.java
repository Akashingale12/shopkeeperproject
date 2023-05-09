package com.shopkeeperbilling.dto;

public class ResponseErrorDTO {

    String field_name;
    String error_message;

    public ResponseErrorDTO(String error_message) {
        this.field_name = null;
        this.error_message = error_message;
    }
}
