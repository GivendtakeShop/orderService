package com.givendtake.orderMicroservice.services.product;


import com.givendtake.orderMicroservice.entities.Order;
import com.givendtake.orderMicroservice.entities.Product;
import com.givendtake.orderMicroservice.entities.ProductOrder;

public interface ProductService {
    Product findById(String id);
    void updateProductQuantity(Order order);
}