package com.givendtake.orderMicroservice.commands;


import static com.givendtake.orderMicroservice.utilities.Assert.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.givendtake.orderMicroservice.services.product.ProductService;
import com.givendtake.orderMicroservice.utilities.Validatable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ProductOrderCommand implements Validatable {

    private final String productId;
    private final int productQuantity;

    private final ProductService productService;

    @Override
    public void validate() {

        assertNotEmpty(productId);
        assertNotNull(productQuantity);
        assertLessThan(productQuantity,productService.findById(productId).getQuantity());
    }
}
