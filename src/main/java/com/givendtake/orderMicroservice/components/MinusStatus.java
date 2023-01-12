package com.givendtake.orderMicroservice.components;

import com.givendtake.orderMicroservice.entities.Product;

public class MinusStatus implements State{


    @Override
    public void update(Product product, int quantity) {
        product.setQuantity(product.getQuantity()-quantity);
    }
}
