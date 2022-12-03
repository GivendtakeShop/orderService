package com.givendtake.orderMicroservice.services.product;

import com.givendtake.orderMicroservice.entities.Product;
import com.givendtake.orderMicroservice.exceptions.BusinessException;
import com.givendtake.orderMicroservice.repositories.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.reset;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;


    @AfterEach
    private void teardown(){
        reset(productRepository);
    }


    @Test
    public void given_existing_product_id_should_return_product(){
        //Given
        String id = "1";

        Product product = new Product();
        product.setId(id);
        product.setName("tshirt");
        product.setPrice(50);

        when(productRepository.findById(id)).thenReturn(Optional.of(product));

        //When
        Product productTest = productService.findById(id);

        //Then
        verify(productRepository).findById(id);
        assertThat(productTest).usingRecursiveComparison()
                .isEqualTo(product);

    }

    @Test
    public void given_not_existing_product_id_should_throw_not_found_exception(){
        //Given
        String id = "1";

        when(productRepository.findById(id)).thenReturn(Optional.empty());

        //When
        Throwable thrown = catchThrowable(()->productService.findById(id));

        //Then
        verify(productRepository).findById(id);
        assertThat(thrown).isInstanceOf(BusinessException.class)
                .hasMessage("product.not.found");


    }
}
