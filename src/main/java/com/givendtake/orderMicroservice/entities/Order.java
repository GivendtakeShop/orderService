package com.givendtake.orderMicroservice.entities;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
@EntityListeners(value = AuditingEntityListener.class)
public class Order extends BaseEntity{

    @CreatedDate
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.PENDING;

//    @OneToMany(mappedBy = "order")
//    private List<ProductOrder> productOrders;
}
