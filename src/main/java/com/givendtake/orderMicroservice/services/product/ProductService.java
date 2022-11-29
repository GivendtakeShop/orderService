package com.givendtake.orderMicroservice.services.product;


import com.givendtake.orderMicroservice.entities.Product;

public interface ProductService {
    Product findById(String id);
}
