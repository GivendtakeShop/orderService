package com.givendtake.orderMicroservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductOrderDTO {

    private String productId;
    private int productQuantity;
}
