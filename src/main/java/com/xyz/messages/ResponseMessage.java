package com.xyz.messages;

public class ResponseMessage<T> {

    private T responseClassType ;

    public ResponseMessage(T responseClassType) {
        this.responseClassType = responseClassType;
    }

    public static <T> ResponseMessage<T> withResponseData(T classType) {
        return new ResponseMessage<T>(classType);
    }
}
