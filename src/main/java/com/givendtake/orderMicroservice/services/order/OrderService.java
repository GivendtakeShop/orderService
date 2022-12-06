package com.givendtake.orderMicroservice.services.order;


import com.givendtake.orderMicroservice.commands.OrderCommand;
import com.givendtake.orderMicroservice.entities.Order;
import com.givendtake.orderMicroservice.entities.OrderStatus;
import org.springframework.data.domain.Page;

import java.util.Date;

public interface OrderService {
    Order addOrder(OrderCommand orderCommand);

    Page<Order> getOrders(int pageNb, int pageSize);

    Order getOrder(String id);

    Page<Order> filterOrders(int pageNb, int pageSize, OrderStatus status, String orderDate);

    void deleteOrder(String id);

}
