package com.givendtake.orderMicroservice.dtos.mappers;


import com.givendtake.orderMicroservice.dtos.OrderDTO;
import com.givendtake.orderMicroservice.entities.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    public OrderDTO orderToOrderDTO(Order order);
}
