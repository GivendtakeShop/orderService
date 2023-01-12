package com.givendtake.orderMicroservice.services.order;

import com.givendtake.orderMicroservice.commands.OrderCommand;
import com.givendtake.orderMicroservice.commands.OrderStatusCommand;
import com.givendtake.orderMicroservice.commands.mappers.OrderMapper;
import com.givendtake.orderMicroservice.components.AddState;
import com.givendtake.orderMicroservice.components.MinusStatus;
import com.givendtake.orderMicroservice.components.ProductQuantityContext;
import com.givendtake.orderMicroservice.entities.Order;
import com.givendtake.orderMicroservice.entities.OrderStatus;
import com.givendtake.orderMicroservice.exceptions.BusinessException;
import com.givendtake.orderMicroservice.exceptions.ExceptionPayloadFactory;
import com.givendtake.orderMicroservice.repositories.OrderRepository;
import com.givendtake.orderMicroservice.services.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ProductService productService;
    private final ProductQuantityContext productQuantityContext;

    @Override
    @Transactional
    public Order addOrder(OrderCommand orderCommand) {

        orderCommand.validate();
        Order order = orderMapper.orderCommandToOrder(orderCommand,Optional.empty());
        productQuantityContext.setState(new MinusStatus());
        productService.updateProductQuantity(order);
        order = orderRepository.save(order);
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
    @Transactional
    public Order updateOrder(String id, OrderCommand orderCommand) {
        orderCommand.validate();

        Order order = getOrder(id);
        productQuantityContext.setState(new AddState());
        productService.updateProductQuantity(order);

        order = orderMapper.orderCommandToOrder(orderCommand, Optional.of(order));
        productQuantityContext.setState(new MinusStatus());
        productService.updateProductQuantity(order);

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
    @Transactional
    public void deleteOrder(String id) {
        Order order = getOrder(id);
        productQuantityContext.setState(new AddState());
        productService.updateProductQuantity(order);
        orderRepository.delete(order);

    }


}
