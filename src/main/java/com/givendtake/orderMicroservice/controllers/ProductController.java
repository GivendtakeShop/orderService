//package com.givendtake.orderMicroservice.controllers;
//
//import com.givendtake.orderMicroservice.commands.OrderCommand;
//import com.givendtake.orderMicroservice.dtos.OrderDTO;
//import com.givendtake.orderMicroservice.dtos.mappers.OrderDTOMapper;
//import com.givendtake.orderMicroservice.entities.Order;
//import com.givendtake.orderMicroservice.entities.Product;
//import com.givendtake.orderMicroservice.services.order.OrderService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import static com.givendtake.orderMicroservice.constants.PathConstant.*;
//import static com.givendtake.orderMicroservice.proxies.constants.PathConstant.PRODUCT;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping(API+V1+PRODUCT)
//public class ProductController {
//    private final OrderService orderService;
//    private final OrderDTOMapper orderMapper;
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Product addProduct(@RequestBody OrderCommand orderCommand){
//        Order order = orderService.addOrder(orderCommand);
//        return orderMapper.orderToOrderDTO(order);
//    }
//}
//
//
//
//
//