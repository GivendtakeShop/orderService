package com.givendtake.orderMicroservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExceptionPayloadFactory {


    //Product not found Exception
    PRODUCT_NOT_FOUND(-1, HttpStatus.NOT_FOUND, "product.not.found"),

    // Technical Exception
    TECHNICAL_ERROR(0, HttpStatus.INTERNAL_SERVER_ERROR, "technical.error"),

    // Business Exception
    INVALID_PAYLOAD(1, HttpStatus.BAD_REQUEST, "invalid.request.payload");

   

    private final Integer code;
    private final HttpStatus status;
    private final String message;

    public ExceptionPayload get() {
        return new ExceptionPayload(code, status, message);
    }

}
