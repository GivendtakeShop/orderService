package com.givendtake.orderMicroservice.commands.mappers;

import com.givendtake.orderMicroservice.commands.OrderCommand;
import com.givendtake.orderMicroservice.commands.ProductOrderCommand;
import com.givendtake.orderMicroservice.entities.Order;
import com.givendtake.orderMicroservice.entities.Product;
import com.givendtake.orderMicroservice.entities.ProductOrder;
import com.givendtake.orderMicroservice.services.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final ProductService productService;

    public ProductOrder productOrderCommandToProductOrder(ProductOrderCommand productOrderCommand, Order order){
        Product p = productService.findById(productOrderCommand.getProductId());
        return ProductOrder.builder()
                .order(order)
                .product(p)
                .productQuantity(productOrderCommand.getProductQuantity())
                .build();
    }

    public Order orderCommandToOrder(OrderCommand orderCommand){
        Order order = new Order();

        List<ProductOrder> productOrders =
                orderCommand.getProductOrders()
                        .stream().map(e -> productOrderCommandToProductOrder(e,order))
                        .toList();

        order.setProductOrders(productOrders);

        return order;
    }
}