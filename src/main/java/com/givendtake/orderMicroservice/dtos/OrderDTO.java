package com.givendtake.orderMicroservice.dtos;


import com.givendtake.orderMicroservice.entities.OrderStatus;
import com.givendtake.orderMicroservice.entities.ProductOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OrderDTO {

    private String id;
    private Date order;
    private OrderStatus status;
    private List<ProductOrder> productOrders;
}
