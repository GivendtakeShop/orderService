package com.givendtake.orderMicroservice.services.order;


import com.givendtake.orderMicroservice.commands.OrderCommand;
import com.givendtake.orderMicroservice.entities.Order;

import java.util.List;

public interface OrderService {
    Order addOrder(OrderCommand orderCommand);

    List<Order> getOrders();

    Order getOrder(String id);

    void deleteOrder(String id);
}
