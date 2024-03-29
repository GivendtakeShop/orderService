package com.givendtake.orderMicroservice.commands.mappers;

import com.givendtake.orderMicroservice.commands.OrderCommand;
import com.givendtake.orderMicroservice.entities.Order;
import com.givendtake.orderMicroservice.entities.ProductOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final ProductOrderMapper productOrderMapper;

    public Order orderCommandToOrder(OrderCommand orderCommand, Optional<Order> optOrder) {
        Order order = optOrder.orElse(new Order());

        List<ProductOrder> productOrders = new ArrayList<>(orderCommand.getProductOrders()
                .stream().map(productOrderMapper::productOrderCommandToProductOrder)
                .toList());
        productOrders.forEach(el -> el.setOrder(order));
        order.setProductOrders(productOrders);

        return order;
    }
}