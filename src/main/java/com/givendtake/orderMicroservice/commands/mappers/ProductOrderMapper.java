package com.givendtake.orderMicroservice.commands.mappers;

import com.givendtake.orderMicroservice.commands.ProductOrderCommand;
import com.givendtake.orderMicroservice.entities.Order;
import com.givendtake.orderMicroservice.entities.Product;
import com.givendtake.orderMicroservice.entities.ProductOrder;
import com.givendtake.orderMicroservice.services.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductOrderMapper {
    private final ProductService productService;

    public ProductOrder productOrderCommandToProductOrder(ProductOrderCommand productOrderCommand){
        Product p = productService.findById(productOrderCommand.getProductId());
        return ProductOrder.builder()
                .product(p)
                .productQuantity(productOrderCommand.getProductQuantity())
                .build();
    }
}
