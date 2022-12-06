package com.givendtake.orderMicroservice.repositories;

import com.givendtake.orderMicroservice.entities.Order;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,String> {
    Page<Order> findAll(Pageable pageable);

    Page<Order> findAll(Example example, Pageable pageable);
}
