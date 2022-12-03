package com.givendtake.orderMicroservice.controllers;

import com.givendtake.orderMicroservice.commands.OrderCommand;
import com.givendtake.orderMicroservice.dtos.OrderDTO;
import com.givendtake.orderMicroservice.dtos.mappers.OrderMapper;
import com.givendtake.orderMicroservice.entities.Order;
import com.givendtake.orderMicroservice.services.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static com.givendtake.orderMicroservice.constants.PathConstant.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(API+V1+ORDER)
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @PostMapping
    public OrderDTO addOrder(@RequestBody OrderCommand orderCommand){
        Order order = orderService.addOrder(orderCommand);
        return orderMapper.orderToOrderDTO(order);
    }

    @GetMapping
    public List<OrderDTO> getOrders(){
        return orderService.getOrders()
                .stream().map(orderMapper::orderToOrderDTO)
                .toList();
    }

}
