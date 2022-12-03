package com.givendtake.orderMicroservice.commands.mappers;

import com.givendtake.orderMicroservice.commands.ProductOrderCommand;
import com.givendtake.orderMicroservice.entities.Order;
import com.givendtake.orderMicroservice.entities.Product;
import com.givendtake.orderMicroservice.entities.ProductOrder;
import com.givendtake.orderMicroservice.services.product.ProductService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ProductOrderMapperTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductOrderMapper productOrderMapper;


    @AfterEach
    private void teardown(){
        reset(productService);
    }


    @Test
    void given_product_order_command_should_return_corresponding_product_order_() {
        //Given

        String productId = "1";
        ProductOrderCommand productOrderCommand = new ProductOrderCommand(productId,50);

        Product product = new Product();
        product.setId("1");
        product.setPrice(50);
        product.setName("tshirt");

        when(productService.findById(productId)).thenReturn(product);



        ProductOrder productOrder =
                ProductOrder.builder()
                        .product(product)
                        .productQuantity(50)
                        .build();
        //When
        ProductOrder productOrderTest =
                productOrderMapper.productOrderCommandToProductOrder(productOrderCommand);

        //Then
        assertThat(productOrderTest)
                .usingRecursiveComparison()
                .isEqualTo(productOrder);

    }
}
