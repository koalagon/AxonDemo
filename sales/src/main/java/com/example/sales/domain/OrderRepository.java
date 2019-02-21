package com.example.sales.domain;

import com.example.sales.domain.OrderAggregate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderAggregate, String> {
}
