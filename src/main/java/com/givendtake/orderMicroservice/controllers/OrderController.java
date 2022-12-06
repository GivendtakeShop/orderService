package com.givendtake.orderMicroservice.controllers;

import com.givendtake.orderMicroservice.commands.OrderCommand;
import com.givendtake.orderMicroservice.commands.OrderStatusCommand;
import com.givendtake.orderMicroservice.dtos.OrderDTO;
import com.givendtake.orderMicroservice.dtos.mappers.OrderMapper;
import com.givendtake.orderMicroservice.entities.Order;
import com.givendtake.orderMicroservice.entities.OrderStatus;
import com.givendtake.orderMicroservice.services.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.Date;

import static com.givendtake.orderMicroservice.constants.PageConstant.PAGE_NB;
import static com.givendtake.orderMicroservice.constants.PageConstant.PAGE_SIZE;
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
    public Page<OrderDTO> getOrders(@RequestParam(defaultValue = PAGE_NB) int pageNb, @RequestParam(defaultValue = PAGE_SIZE) int pageSize){
        return orderService.getOrders(pageNb,pageSize)
                .map(orderMapper::orderToOrderDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public OrderDTO getOrder(@PathVariable String id){
        return orderMapper.orderToOrderDTO(orderService.getOrder(id));
    }


    @GetMapping("/filter")
    @ResponseStatus(HttpStatus.OK)
    public Page<OrderDTO> filterOrders(@RequestParam(defaultValue = PAGE_NB) int pageNb, @RequestParam(defaultValue = PAGE_SIZE) int pageSize,
               @RequestParam(required = false) OrderStatus status, @RequestParam(required = false) String orderDate){
        return orderService.filterOrders(pageNb, pageSize, status,orderDate)
                .map(orderMapper::orderToOrderDTO);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDTO changeOrderStatus(@PathVariable String id, @RequestBody OrderStatusCommand statusCommand){
        return orderMapper.orderToOrderDTO(orderService.changeOrderStatus(id, statusCommand));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrder(@PathVariable String id){
        orderService.deleteOrder(id);
    }


}
