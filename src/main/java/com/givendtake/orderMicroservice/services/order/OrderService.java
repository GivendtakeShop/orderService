package com.givendtake.orderMicroservice.services.order;


import com.givendtake.orderMicroservice.commands.OrderCommand;
import com.givendtake.orderMicroservice.entities.Order;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderService {
    Order addOrder(OrderCommand orderCommand);

    Page<Order> getOrders(int pageNb, int pageSize);

    Order getOrder(String id);

    void deleteOrder(String id);
}
