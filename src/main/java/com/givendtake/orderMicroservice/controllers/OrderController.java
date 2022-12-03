package com.givendtake.orderMicroservice.controllers;

import com.givendtake.orderMicroservice.commands.OrderCommand;
import com.givendtake.orderMicroservice.dtos.OrderDTO;
import com.givendtake.orderMicroservice.dtos.mappers.OrderMapper;
import com.givendtake.orderMicroservice.entities.Order;
import com.givendtake.orderMicroservice.services.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO addOrder(@RequestBody OrderCommand orderCommand){
        Order order = orderService.addOrder(orderCommand);
        return orderMapper.orderToOrderDTO(order);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDTO> getOrders(){
        return orderService.getOrders()
                .stream().map(orderMapper::orderToOrderDTO)
                .toList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public OrderDTO getOrder(@PathVariable String id){
        return orderMapper.orderToOrderDTO(orderService.getOrder(id));
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrder(@PathVariable String id){
        orderService.deleteOrder(id);
    }
}
