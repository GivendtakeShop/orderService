package com.givendtake.orderMicroservice.proxies;


import com.givendtake.orderMicroservice.proxies.beans.ProductBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.givendtake.orderMicroservice.proxies.constants.PathConstant.PRODUCT;
import static com.givendtake.orderMicroservice.proxies.constants.PathConstant.V1;

@FeignClient(name = "ProductService", url = "localhost:8081" + V1+PRODUCT)
public interface ProductProxy {


    @GetMapping
    List<ProductBean> getProducts();

    @GetMapping("/{id}")
    ProductBean getProduct(@PathVariable("id") String id);

    @PutMapping("/{id}/updateQuantity")
    ProductBean updateQuantity(@PathVariable String id, @RequestParam Integer quantity);


    }