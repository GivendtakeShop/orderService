package com.givendtake.orderMicroservice.services.order;


import com.givendtake.orderMicroservice.commands.OrderCommand;
import com.givendtake.orderMicroservice.commands.ProductOrderCommand;
import com.givendtake.orderMicroservice.commands.mappers.OrderMapper;
import com.givendtake.orderMicroservice.entities.Order;
import com.givendtake.orderMicroservice.entities.Product;
import com.givendtake.orderMicroservice.entities.ProductOrder;
import com.givendtake.orderMicroservice.repositories.OrderRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private OrderMapper orderMapper;

    @InjectMocks
    private OrderServiceImpl orderService;


    @AfterEach
    private void teardown(){
        reset(orderRepository);
        reset(orderMapper);
    }


    @Test
    public void should_add_order(){
        //Given
        String productId1 = "1";
        int product1Quantity = 50;
        ProductOrderCommand productOrderCommand1 = new ProductOrderCommand(productId1,product1Quantity);

        String productId2 = "2";
        int product2Quantity = 500;
        ProductOrderCommand productOrderCommand2 = new ProductOrderCommand(productId2,product2Quantity);

        List<ProductOrderCommand> productOrderCommands = new ArrayList<>();
        productOrderCommands.add(productOrderCommand1);
        productOrderCommands.add(productOrderCommand2);

        OrderCommand orderCommand = new OrderCommand();
        orderCommand.setProductOrders(productOrderCommands);


        Product product1 = new Product();
        product1.setId(productId1);

        Product product2 = new Product();
        product2.setId(productId2);


        Order order = new Order();

        ProductOrder productOrder1 =
                ProductOrder.builder()
                        .product(product1)
                        .productQuantity(product1Quantity)
                        .order(order)
                        .build();
        ProductOrder productOrder2 =
                ProductOrder.builder()
                        .product(product2)
                        .productQuantity(product2Quantity)
                        .order(order)
                        .build();

        List<ProductOrder> productOrders = new ArrayList<>();
        productOrders.add(productOrder1);
        productOrders.add(productOrder2);

        order.setProductOrders(productOrders);


        when(orderMapper.orderCommandToOrder(orderCommand))
                .thenReturn(order);

        ArgumentCaptor<Order> argOrder = ArgumentCaptor.forClass(Order.class);
        when(orderRepository.save(any(Order.class)))
                .then(returnsFirstArg());

        //when
        orderService.addOrder(orderCommand);

        //then

        verify(orderMapper).orderCommandToOrder(orderCommand);
        verify(orderRepository).save(argOrder.capture());
        assertThat(argOrder.getValue())
                .usingRecursiveComparison()
                .isEqualTo(order);
    }

}