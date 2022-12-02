package com.givendtake.orderMicroservice.commands.mappers;

import com.givendtake.orderMicroservice.commands.OrderCommand;
import com.givendtake.orderMicroservice.entities.Order;
import com.givendtake.orderMicroservice.entities.ProductOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final ProductOrderMapper productOrderMapper;

    public Order orderCommandToOrder(OrderCommand orderCommand){
        Order order = new Order();

        List<ProductOrder> productOrders =
                orderCommand.getProductOrders()
                        .stream().map(e -> productOrderMapper.productOrderCommandToProductOrder(e,order))
                        .toList();

        order.setProductOrders(productOrders);

        return order;
    }
}