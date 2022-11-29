package com.givendtake.orderMicroservice.dtos.mappers;


import com.givendtake.orderMicroservice.dtos.ProductOrderDTO;
import com.givendtake.orderMicroservice.entities.ProductOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductOrderMapper {

    @Mapping(target = "productId",expression = "java(productOrder.getProduct().getId())")
    public ProductOrderDTO productOrderToProductOrderDTO(ProductOrder productOrder);

}
