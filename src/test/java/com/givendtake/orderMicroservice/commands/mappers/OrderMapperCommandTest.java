package com.givendtake.orderMicroservice.commands.mappers;

import com.givendtake.orderMicroservice.commands.OrderCommand;
import com.givendtake.orderMicroservice.commands.ProductOrderCommand;
import com.givendtake.orderMicroservice.entities.Order;
import com.givendtake.orderMicroservice.entities.Product;
import com.givendtake.orderMicroservice.entities.ProductOrder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class OrderMapperCommandTest {


    @Mock
    private ProductOrderCommandMapper productOrderMapper;

    @InjectMocks
    private OrderCommandMapper orderMapper;


    @AfterEach
    private void teardown(){
        reset(productOrderMapper);
    }


    @Test
    void given_order_command_should_return_corresponding_order() {
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

       when(productOrderMapper.productOrderCommandToProductOrder(productOrderCommand1))
               .thenReturn(productOrder1);
       when(productOrderMapper.productOrderCommandToProductOrder(productOrderCommand2))
               .thenReturn(productOrder2);


        //When
        Order orderTest = orderMapper.orderCommandToOrder(orderCommand, Optional.empty());

        //Then
        verify(productOrderMapper,times(productOrderCommands.size())).productOrderCommandToProductOrder(any(ProductOrderCommand.class));
        assertThat(orderTest)
                .usingRecursiveComparison()
                .isEqualTo(order);
    }

}