package com.givendtake.orderMicroservice.entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_orders")
@Builder
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
