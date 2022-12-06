package com.givendtake.orderMicroservice.commands;

import com.givendtake.orderMicroservice.entities.OrderStatus;
import com.givendtake.orderMicroservice.utilities.Validatable;
import lombok.Getter;

import static com.givendtake.orderMicroservice.utilities.Assert.assertNotNull;

@Getter
public class OrderStatusCommand implements Validatable {
    private OrderStatus orderStatus;

    @Override
    public void validate() {
        assertNotNull(orderStatus);
    }
}
