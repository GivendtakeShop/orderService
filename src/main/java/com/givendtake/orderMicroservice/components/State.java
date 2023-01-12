package com.givendtake.orderMicroservice.components;

import com.givendtake.orderMicroservice.entities.Product;

public interface State {

    void update(Product product,int quantity);
}
