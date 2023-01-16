package com.givendtake.orderMicroservice.commands.mappers;

import com.givendtake.orderMicroservice.commands.ProductOrderCommand;
import com.givendtake.orderMicroservice.entities.Product;
import com.givendtake.orderMicroservice.entities.ProductOrder;
import com.givendtake.orderMicroservice.proxies.ProductProxy;
import com.givendtake.orderMicroservice.proxies.beans.ProductBean;
import com.givendtake.orderMicroservice.services.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductOrderCommandMapper {
    private final ProductProxy productProxy;

    public ProductOrder productOrderCommandToProductOrder(ProductOrderCommand productOrderCommand){
        ProductBean p = productProxy.getProduct(productOrderCommand.getProductId());
        return ProductOrder.builder()
                .productId(productOrderCommand.getProductId())
                .productQuantity(productOrderCommand.getProductQuantity())
                .build();
    }
}
