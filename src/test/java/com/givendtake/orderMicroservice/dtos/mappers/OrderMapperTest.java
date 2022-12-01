package com.givendtake.orderMicroservice.dtos.mappers;

import com.givendtake.orderMicroservice.dtos.OrderDTO;
import com.givendtake.orderMicroservice.dtos.ProductOrderDTO;
import com.givendtake.orderMicroservice.entities.Order;
import com.givendtake.orderMicroservice.entities.OrderStatus;
import com.givendtake.orderMicroservice.entities.Product;
import com.givendtake.orderMicroservice.entities.ProductOrder;
import lombok.RequiredArgsConstructor;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = OrderMapperImpl.class)
class OrderMapperTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    void given_product_order_should_return_corresponding_product_order_dto() {
        //Given
        Product product = new Product();
        product.setId("1");

        ProductOrder productOrder =
                ProductOrder.builder()
                        .product(product)
                        .productQuantity(50)
                        .build();



        //When
        ProductOrderDTO productOrderDTO =
                orderMapper.productOrderToProductOrderDTO(productOrder);

        //Then
        ProductOrderDTO productOrderDTOGiven = new ProductOrderDTO();
        productOrderDTOGiven.setProductId("1");
        productOrderDTOGiven.setProductQuantity(50);

        assertThat(productOrderDTO)
                .as("testing map product_order to its dto --------------")
                .usingRecursiveComparison()
                .isEqualTo(productOrderDTOGiven);


    }

    @Test
    void given_order_should_return_corresponding_order_dto() {
        //Given
        Product product1 = new Product();
        product1.setId("1");

        Product product2 = new Product();
        product2.setId("2");

        ProductOrder productOrder1 =
                ProductOrder.builder()
                        .product(product1)
                        .productQuantity(100)
                        .build();
        ProductOrder productOrder2 =
                ProductOrder.builder()
                        .product(product2)
                        .productQuantity(50)
                        .build();

        List<ProductOrder> productOrders = new ArrayList<>();
        productOrders.add(productOrder1);
        productOrders.add(productOrder2);

        Date orderDate = new Date();

        Order order =
                Order.builder()
                        .orderDate(orderDate)
                        .status(OrderStatus.PENDING)
                        .productOrders(productOrders)
                        .build();

        //tested with objects

        ProductOrderDTO productOrderDTO1 = new ProductOrderDTO();
        productOrderDTO1.setProductId("1");
        productOrderDTO1.setProductQuantity(100);

        ProductOrderDTO productOrderDTO2 = new ProductOrderDTO();
        productOrderDTO2.setProductId("2");
        productOrderDTO2.setProductQuantity(50);

        List<ProductOrderDTO> productOrderDTOS = new ArrayList<>();
        productOrderDTOS.add(productOrderDTO1);
        productOrderDTOS.add(productOrderDTO2);

        OrderDTO orderDTOGiven = new OrderDTO();
        orderDTOGiven.setOrderDate(orderDate);
        orderDTOGiven.setStatus(OrderStatus.PENDING);
        orderDTOGiven.setProductOrders(productOrderDTOS);

        //When
        OrderDTO orderDTO = orderMapper.orderToOrderDTO(order);

        //Then
        assertThat(orderDTO)
                .as("testing map order to its dto")
                .usingRecursiveComparison()
                .isEqualTo(orderDTOGiven);
    }

    @Test
    void given_product_should_return_its_id() {
        //Given
        Product product =
                Product.builder()
                        .price(50)
                        .name("T-shirt")
                        .build();
        product.setId("1");
        //When
        String id = orderMapper.getProductId(product);

        //Then
        assertThat(id)
                .as("Testing getProductId ----------------")
                        .isEqualTo(product.getId());
    }
}