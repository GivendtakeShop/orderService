package com.givendtake.orderMicroservice.dtos.mappers;

import com.givendtake.orderMicroservice.dtos.ProductOrderDTO;
import com.givendtake.orderMicroservice.entities.Product;
import com.givendtake.orderMicroservice.entities.ProductOrder;
import com.givendtake.orderMicroservice.proxies.ProductProxy;
import com.givendtake.orderMicroservice.proxies.beans.ProductBean;
import com.givendtake.orderMicroservice.proxies.beans.ProductTypeBean;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ProductOrderDTOMapperTest {

    @Mock
    private ProductProxy productProxy;

    @InjectMocks
    private ProductOrderDTOMapper productOrderMapper;

    @Test
    void given_product_order_should_return_corresponding_product_order_dto() {
        //Given
        String productId = "1";
        int productQuatity = 50;

        Product product = new Product();
        product.setId(productId);

        ProductOrder productOrder =
                ProductOrder.builder()
                        .product(product)
                        .productQuantity(productQuatity)
                        .build();

        ProductBean productBean = new ProductBean();
        productBean.setId(productId);
        productBean.setName("tshirt");
        productBean.setPrice(50);
        productBean.setType(ProductTypeBean.CLOTHES);
        productBean.setDescription("erer");

        when(productProxy.getProduct(productId)).thenReturn(productBean);



        //When
        ProductOrderDTO productOrderDTO =
                productOrderMapper.productOrderToProductOrderDTO(productOrder);

        //Then
        ProductOrderDTO productOrderDTOGiven = new ProductOrderDTO();
        productOrderDTOGiven.setProduct(productBean);
        productOrderDTOGiven.setProductQuantity(productQuatity);

        verify(productProxy).getProduct(productId);
        assertThat(productOrderDTO)
                .as("testing map product_order to its dto --------------")
                .usingRecursiveComparison()
                .isEqualTo(productOrderDTOGiven);


    }


}