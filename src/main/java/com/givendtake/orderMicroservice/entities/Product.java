package com.givendtake.orderMicroservice.entities;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product extends BaseEntity{
}
