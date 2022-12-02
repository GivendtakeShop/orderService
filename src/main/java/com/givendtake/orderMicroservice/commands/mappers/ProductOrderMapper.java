package com.givendtake.orderMicroservice.commands.mappers;

import com.givendtake.orderMicroservice.commands.ProductOrderCommand;
import com.givendtake.orderMicroservice.entities.Order;
import com.givendtake.orderMicroservice.entities.Product;
import com.givendtake.orderMicroservice.entities.ProductOrder;
import com.givendtake.orderMicroservice.services.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class ProductOrderMapper {

    private final ProductService productService;

    public ProductOrder productOrderCommandToProductOrder(ProductOrderCommand productOrderCommand, Order order){
        Product p = productService.findById(productOrderCommand.getProductId());
        return ProductOrder.builder()
                .order(order)
                .product(p)
                .productQuantity(productOrderCommand.getProductQuantity())
                .build();
    }

}