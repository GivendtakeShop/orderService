package com.givendtake.orderMicroservice.proxies.beans;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductBean {

    private String id;
    private String name;
    private long price;
    private ProductTypeBean type;
    private String description;
    private int quantity;

}
