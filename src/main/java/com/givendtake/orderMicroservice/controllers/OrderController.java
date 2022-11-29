package com.givendtake.orderMicroservice.controllers;

import com.givendtake.orderMicroservice.dtos.mappers.OrderMapper;
import com.givendtake.orderMicroservice.services.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static com.givendtake.orderMicroservice.constants.PathConstant.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(API+V1+ORDER)
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

}
