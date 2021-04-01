package com.switchfully.eurder.domain.repositories;

import com.switchfully.eurder.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

//THIS CLASS IS USELESS : I KEEP IT FOR POTENTIAL REFACTORING

@Repository
public class OrderRepository {
    private final Map<UUID, Order> orderDatabase;

    public OrderRepository(){
        this.orderDatabase = new HashMap<>();
    }

    public void addNewOrder(Order order) {
        orderDatabase.put(order.getUuid(),order);
    }

}
