package com.givendtake.orderMicroservice.exceptions;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final ExceptionPayload payload;

    public BusinessException(ExceptionPayload payload) {
        super(payload.getMessage());
        this.payload = payload;
    }

}

