package com.givendtake.orderMicroservice.dtos.mappers;


import com.givendtake.orderMicroservice.dtos.OrderDTO;
import com.givendtake.orderMicroservice.dtos.ProductOrderDTO;
import com.givendtake.orderMicroservice.entities.Order;
import com.givendtake.orderMicroservice.entities.Product;
import com.givendtake.orderMicroservice.entities.ProductOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "productId",source = "product", qualifiedByName = "getProductId")
    public ProductOrderDTO productOrderToProductOrderDTO(ProductOrder source);

    public OrderDTO orderToOrderDTO(Order source);

    @Named("getProductId")
    public default String getProductId(Product product){
        return product.getId();
    }
}
