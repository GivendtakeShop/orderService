package com.givendtake.orderMicroservice.services.order;


import com.givendtake.orderMicroservice.commands.OrderCommand;
import com.givendtake.orderMicroservice.entities.Order;

public interface OrderService {
    Order addOrder(OrderCommand orderCommand);
}
