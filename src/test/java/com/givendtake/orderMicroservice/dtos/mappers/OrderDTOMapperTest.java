package com.givendtake.orderMicroservice.dtos.mappers;

import com.givendtake.orderMicroservice.dtos.OrderDTO;
import com.givendtake.orderMicroservice.dtos.ProductOrderDTO;
import com.givendtake.orderMicroservice.entities.Order;
import com.givendtake.orderMicroservice.entities.OrderStatus;
import com.givendtake.orderMicroservice.entities.Product;
import com.givendtake.orderMicroservice.entities.ProductOrder;
import static org.assertj.core.api.Assertions.*;
import com.givendtake.orderMicroservice.proxies.beans.ProductBean;
import com.givendtake.orderMicroservice.proxies.beans.ProductTypeBean;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.ArrayList;
import java.util.List;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = OrderDTOMapperImpl.class)
class OrderDTOMapperTest {

    @Autowired
    private OrderDTOMapper orderMapper;


    @Test
    void given_order_should_return_corresponding_order_dto() {
        //Given
        String productId1 = "1";
        int productQuantity1 = 100;

        String productId2 = "2";
        int productQuantity2 = 50;


        Product product1 = new Product();
        product1.setId(productId1);

        Product product2 = new Product();
        product2.setId(productId2);

        ProductOrder productOrder1 =
                ProductOrder.builder()
                        .product(product1)
                        .productQuantity(productQuantity1)
                        .build();
        ProductOrder productOrder2 =
                ProductOrder.builder()
                        .product(product2)
                        .productQuantity(productQuantity2)
                        .build();

        List<ProductOrder> productOrders = new ArrayList<>();
        productOrders.add(productOrder1);
        productOrders.add(productOrder2);

        String orderDate = "12/6/22, 1:38 AM";

        //****
        Order order =
                Order.builder()
                        .orderDate(orderDate)
                        .status(OrderStatus.PENDING)
                        .productOrders(productOrders)
                        .build();



        ProductBean productBean1 = new ProductBean();
        productBean1.setId(productId1);
        productBean1.setName("tshirt");
        productBean1.setPrice(50);
        productBean1.setType(ProductTypeBean.CLOTHES);
        productBean1.setDescription("erer");

        ProductOrderDTO productOrderDTO1 = new ProductOrderDTO();
        productOrderDTO1.setProductQuantity(productQuantity1);
        productOrderDTO1.setProduct(productBean1);


        ProductBean productBean2 = new ProductBean();
        productBean2.setId(productId2);
        productBean2.setName("fdfsd");
        productBean2.setPrice(500);
        productBean2.setType(ProductTypeBean.CLOTHES);
        productBean2.setDescription("fsd");

        ProductOrderDTO productOrderDTO2 = new ProductOrderDTO();
        productOrderDTO2.setProductQuantity(productQuantity2);
        productOrderDTO2.setProduct(productBean2);


        //When
        OrderDTO orderDTO = orderMapper.orderToOrderDTO(order);

        //Then

        List<ProductOrderDTO> productOrderDTOS = new ArrayList<>();
        productOrderDTOS.add(productOrderDTO1);
        productOrderDTOS.add(productOrderDTO2);

        OrderDTO orderDTOGiven = new OrderDTO();
        orderDTOGiven.setOrderDate(orderDate);
        orderDTOGiven.setStatus(OrderStatus.PENDING);
        orderDTOGiven.setProductOrders(productOrderDTOS);

        //****
        assertThat(orderDTO)
                .as("testing map order to its dto")
                .usingRecursiveComparison()
                .isEqualTo(orderDTOGiven);
    }

}