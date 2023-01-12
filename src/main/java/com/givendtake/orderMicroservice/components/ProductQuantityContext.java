package com.givendtake.orderMicroservice.components;

import com.givendtake.orderMicroservice.entities.Product;
import com.givendtake.orderMicroservice.entities.ProductOrder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class ProductQuantityContext {

    private State state = new AddState();
    private ProductOrder productOrder;


    public void update(Product product, int quantity){
        state.update(product,quantity);
    }


}
