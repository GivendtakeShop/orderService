package com.givendtake.orderMicroservice.dtos.mappers;

import com.givendtake.orderMicroservice.dtos.ProductOrderDTO;
import com.givendtake.orderMicroservice.entities.Product;
import com.givendtake.orderMicroservice.entities.ProductOrder;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
class ProductOrderMapperTest {


    private final ProductOrderMapper productOrderMapper;

    @Test
    void given_product_order_should_return_corresponding_product_order_dto(){
        //Given
        Product product = new Product();
        product.setId("1");
        ProductOrder p = new ProductOrder();
        p.setProduct(product);
        p.setOrder(null);
        p.setProductQuantity(50);

        //when
        ProductOrderDTO productOrderDTO = productOrderMapper.productOrderToProductOrderDTO(p);

        //then
        ProductOrderDTO  testProductOrderDTO = new ProductOrderDTO();
        testProductOrderDTO.setProductId("1");
        testProductOrderDTO.setProductQuantity(50);

        assertThat(productOrderDTO)
                .usingRecursiveComparison()
                .isEqualTo(testProductOrderDTO);

    }

}