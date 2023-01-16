package com.givendtake.orderMicroservice.services.order;

import com.givendtake.orderMicroservice.commands.OrderCommand;
import com.givendtake.orderMicroservice.commands.OrderStatusCommand;
import com.givendtake.orderMicroservice.commands.mappers.OrderCommandMapper;
import com.givendtake.orderMicroservice.entities.Order;
import com.givendtake.orderMicroservice.entities.OrderStatus;
import com.givendtake.orderMicroservice.entities.ProductOrder;
import com.givendtake.orderMicroservice.exceptions.BusinessException;
import com.givendtake.orderMicroservice.exceptions.ExceptionPayloadFactory;
import com.givendtake.orderMicroservice.proxies.ProductProxy;
import com.givendtake.orderMicroservice.proxies.beans.ProductBean;
import com.givendtake.orderMicroservice.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final OrderCommandMapper orderMapper;
    private final ProductProxy productProxy;

    @Override
    public Order addOrder(OrderCommand orderCommand) {

        orderCommand.validate();
        Order order = orderMapper.orderCommandToOrder(orderCommand,Optional.empty());
        orderRepository.save(order);
        boolean tansactionValid = true;
        for (ProductOrder p: order.getProductOrders() ) {
            ProductBean productBean = productProxy.updateQuantity(p.getProductId(),p.getProductQuantity());

        }

        return order;
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
    public Order updateOrder(String id, OrderCommand orderCommand) {
        orderCommand.validate();
        Order order = getOrder(id);
        order = orderMapper.orderCommandToOrder(orderCommand, Optional.of(order));

        return orderRepository.save(order);
    }


    @Override
    public Order changeOrderStatus(String id, OrderStatusCommand statusCommand) {
        statusCommand.validate();
        Order order = getOrder(id);
        order.setStatus(statusCommand.getOrderStatus());

        return orderRepository.save(order);
    }


    @Override
    public void deleteOrder(String id) {
        Order order = getOrder(id);
        orderRepository.delete(order);
    }


}
