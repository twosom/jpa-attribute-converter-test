package com.icloud.converter.repository;

import com.icloud.converter.entityy.Order;
import com.icloud.converter.value.Money;
import com.icloud.converter.value.OrderNo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Transactional
@SpringBootTest
class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    EntityManager em;

    @Test
    void test() {
        Money money = new Money(1_000, "원");
        OrderNo orderNo = new OrderNo("test_order_no");
        Order order = new Order(orderNo, money);
        orderRepository.save(order);
        em.flush();
        em.clear();

        List<Order> all = orderRepository.findAll();
        assertFalse(all.isEmpty());
        Order findOrder = all.get(0);
        assertEquals(findOrder.getTotalAmounts(), money);
        assertEquals(findOrder.getNumber(), orderNo);

    }

}