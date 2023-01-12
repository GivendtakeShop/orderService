package com.givendtake.orderMicroservice.entities;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
@Builder
@EntityListeners(value = AuditingEntityListener.class)
public class Order extends BaseEntity{

    @CreatedDate
    private String orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.PENDING;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<ProductOrder> productOrders = new ArrayList<>();

    private void removeProductOrder(ProductOrder productOrder){
        productOrders.remove(productOrder);
        productOrder.setOrder(null);
    }

    public void clearProductOrders(){
        productOrders.forEach(e->e.setOrder(null));
        productOrders.clear();
    }
}
