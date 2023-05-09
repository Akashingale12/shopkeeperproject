package com.shopkeeperbilling.structure;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "ResponseStatus", "ResponseMessage" })
public class HttpResponseStatus {
    @JsonProperty("ResponseStatus")
    private Integer ResponseStatus;
    @JsonProperty("ResponseMessage")
    private Object ResponseMessage;

    public HttpResponseStatus(Integer responseStatus, Object responseMessage) {
        super();
        ResponseStatus = responseStatus;
        ResponseMessage = responseMessage;
    }

    @JsonProperty("ResponseStatus")
    public int getResponseStatus() {
        return ResponseStatus;
    }

    @JsonProperty("ResponseStatus")
    public void setResponseStatus(Integer responseStatus) {
        this.ResponseStatus = responseStatus;
    }

    @JsonProperty("ResponseMessage")
    public Object getResponseMessage() {
        return ResponseMessage;
    }

    @JsonProperty("ResponseMessage")
    public void setResponseMessage(Object responseMessage) {
        this.ResponseMessage = responseMessage;
    }
}
