package com.givendtake.orderMicroservice.commands;


import static com.givendtake.orderMicroservice.utilities.Assert.*;
import com.givendtake.orderMicroservice.utilities.Validatable;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderCommand implements Validatable {

    private List<ProductOrderCommand> productOrders;

    @Override
    public void validate() {

        assertNotEmpty(productOrders);
        productOrders.forEach(ProductOrderCommand::validate);
    }
}