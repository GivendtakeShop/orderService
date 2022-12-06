package com.givendtake.orderMicroservice.services.order;

import com.givendtake.orderMicroservice.commands.OrderCommand;
import com.givendtake.orderMicroservice.commands.mappers.OrderMapper;
import com.givendtake.orderMicroservice.entities.Order;
import com.givendtake.orderMicroservice.entities.OrderStatus;
import com.givendtake.orderMicroservice.exceptions.BusinessException;
import com.givendtake.orderMicroservice.exceptions.ExceptionPayloadFactory;
import com.givendtake.orderMicroservice.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.domain.ExampleMatcher.PropertyValueTransformer;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @Override
    public Page<Order> getOrders(int pageNb, int pageSize) {
        Pageable pageable = PageRequest.of(pageNb, pageSize, Sort.by("orderDate").descending());
        return orderRepository.findAll(pageable);
    }

    @Override
    public Order getOrder(String id) {
        return orderRepository.findById(id)
                .orElseThrow(()-> new BusinessException(ExceptionPayloadFactory.ORDER_NOT_FOUND.get()));
    }

    @Override
    public Page<Order> filterOrders(int pageNb, int pageSize, OrderStatus status, String orderDate) {
        Pageable pageable = PageRequest.of(pageNb, pageSize, Sort.by("orderDate").descending());

        Order order = new Order();
        order.setOrderDate(orderDate);
        order.setStatus(status);

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withMatcher("orderDate",ExampleMatcher.GenericPropertyMatchers.startsWith());

        Example<Order> example = Example.of(order,matcher);

        return orderRepository.findAll(example, pageable);
    }

    @Override
    public void deleteOrder(String id) {
        Order order = getOrder(id);
        orderRepository.delete(order);
    }

}
