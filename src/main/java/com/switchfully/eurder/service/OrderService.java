package com.switchfully.eurder.service;

import com.switchfully.eurder.api.Dtos.Order.GetOrderDto;
import com.switchfully.eurder.domain.Order;
import com.switchfully.eurder.domain.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void addNewOrder(Order order){
        orderRepository.addNewOrder(order);
    }

}
