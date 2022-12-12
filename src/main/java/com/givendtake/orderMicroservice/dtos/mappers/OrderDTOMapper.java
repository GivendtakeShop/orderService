package com.givendtake.orderMicroservice.dtos.mappers;


import com.givendtake.orderMicroservice.dtos.OrderDTO;
import com.givendtake.orderMicroservice.entities.Order;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {ProductOrderDTOMapper.class})
public interface OrderDTOMapper {

    public OrderDTO orderToOrderDTO(Order source);


}
