package com.givendtake.orderMicroservice.services.order;

import com.givendtake.orderMicroservice.commands.OrderCommand;
import com.givendtake.orderMicroservice.commands.mappers.OrderMapper;
import com.givendtake.orderMicroservice.entities.Order;
import com.givendtake.orderMicroservice.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public Order addOrder(OrderCommand orderCommand) {

        orderCommand.validate();
        Order order = orderMapper.orderCommandToOrder(orderCommand);
        return orderRepository.save(order);
    }
}
