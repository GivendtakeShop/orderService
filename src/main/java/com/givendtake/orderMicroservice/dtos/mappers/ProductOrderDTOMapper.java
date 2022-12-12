package com.givendtake.orderMicroservice.dtos.mappers;

import com.givendtake.orderMicroservice.dtos.ProductOrderDTO;
import com.givendtake.orderMicroservice.entities.Product;
import com.givendtake.orderMicroservice.entities.ProductOrder;
import com.givendtake.orderMicroservice.proxies.ProductProxy;
import com.givendtake.orderMicroservice.proxies.beans.ProductBean;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class ProductOrderDTOMapper {

    private final ProductProxy productProxy;

    public ProductOrderDTO productOrderToProductOrderDTO(ProductOrder source) {
        if ( source == null ) {
            return null;
        }

        ProductOrderDTO productOrderDTO = new ProductOrderDTO();

        productOrderDTO.setProduct( productProxy.getProduct( source.getProduct().getId() ) );
        productOrderDTO.setProductQuantity( source.getProductQuantity() );

        return productOrderDTO;

    }


}
