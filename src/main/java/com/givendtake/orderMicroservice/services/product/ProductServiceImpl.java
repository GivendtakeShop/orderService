package com.givendtake.orderMicroservice.services.product;


import com.givendtake.orderMicroservice.entities.Product;
import com.givendtake.orderMicroservice.exceptions.BusinessException;
import com.givendtake.orderMicroservice.exceptions.ExceptionPayloadFactory;
import com.givendtake.orderMicroservice.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    @Override
    public Product findById(String id) {
        return productRepository
                .findById(id)
                .orElseThrow(()-> new BusinessException(ExceptionPayloadFactory.PRODUCT_NOT_FOUND.get()));
    }
}
