package com.givendtake.orderMicroservice.dtos;


import com.givendtake.orderMicroservice.entities.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OrderDTO {

    private String id;
    private String orderDate;
    private OrderStatus status;
    private List<ProductOrderDTO> productOrders;
}
