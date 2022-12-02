package com.givendtake.orderMicroservice.commands;


import static com.givendtake.orderMicroservice.utilities.Assert.*;
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

    @Override
    public void validate() {

        assertNotEmpty(productId);
        assertNotNull(productQuantity);
    }
}
