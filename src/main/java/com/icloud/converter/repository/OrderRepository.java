package com.icloud.converter.repository;

import com.icloud.converter.entityy.Order;
import com.icloud.converter.value.OrderNo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, OrderNo> {

}
