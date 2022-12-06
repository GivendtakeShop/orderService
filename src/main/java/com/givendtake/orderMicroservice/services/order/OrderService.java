package com.givendtake.orderMicroservice.services.order;


import com.givendtake.orderMicroservice.commands.OrderCommand;
import com.givendtake.orderMicroservice.commands.OrderStatusCommand;
import com.givendtake.orderMicroservice.dtos.OrderDTO;
import com.givendtake.orderMicroservice.entities.Order;
import com.givendtake.orderMicroservice.entities.OrderStatus;
import org.springframework.data.domain.Page;

import java.util.Date;

public interface OrderService {
    Order addOrder(OrderCommand orderCommand);

    Page<Order> getOrders(int pageNb, int pageSize);

    Order getOrder(String id);

    Page<Order> filterOrders(int pageNb, int pageSize, OrderStatus status, String orderDate);

    Order updateOrder(String id, OrderCommand orderCommand);

    Order changeOrderStatus(String id, OrderStatusCommand statusCommand);

    void deleteOrder(String id);


}
