package com.shopkeeperbilling.structure;

public class ResponseMessage {

    private String message;
    private Object messageBody;

    public ResponseMessage(String message, Object messageBody) {
        super();
        this.message = message;
        this.messageBody = messageBody;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(Object messageBody) {
        this.messageBody = messageBody;
    }
}
