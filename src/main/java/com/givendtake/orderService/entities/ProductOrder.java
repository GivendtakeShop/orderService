package com.givendtake.orderService.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductOrder {

    @EmbeddedId
    private ProductOrderId id;


    @ManyToOne
    @MapsId("productId")
    private Product product;

    @ManyToOne
    @MapsId("orderId")
    private Order order;


    private int productQuantity;
}

@Embeddable
class ProductOrderId implements Serializable {
    private String productId;
    private String orderId;
}