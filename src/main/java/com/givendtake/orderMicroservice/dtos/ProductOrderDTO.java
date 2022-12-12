package com.givendtake.orderMicroservice.dtos;


import com.givendtake.orderMicroservice.proxies.ProductProxy;
import com.givendtake.orderMicroservice.proxies.beans.ProductBean;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductOrderDTO {

    private ProductBean product;
    private int productQuantity;
}
