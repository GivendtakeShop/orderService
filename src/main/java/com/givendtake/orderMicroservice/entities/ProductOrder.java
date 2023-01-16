package com.givendtake.orderMicroservice.entities;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_orders")
@Builder
public class ProductOrder extends BaseEntity{


    private String productId;

    @ManyToOne
    private Order order;

    private int productQuantity;
}

