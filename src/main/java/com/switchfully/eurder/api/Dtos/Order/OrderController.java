package com.switchfully.eurder.api.Dtos.Order;

import com.switchfully.eurder.domain.Order;
import com.switchfully.eurder.infrastructure.utils.ValidationUtil;
import com.switchfully.eurder.service.CustomerService;
import com.switchfully.eurder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path="/orders")
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;
    private final CustomerService customerService;

    @Autowired
    public OrderController(OrderService orderService, OrderMapper orderMapper, CustomerService customerService) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
        this.customerService = customerService;
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public float createOrder(@RequestBody CreateOrderDto createOrderDto){
        Order order = orderMapper.mapCreateOrderDtoToOrder(createOrderDto);
        orderService.addNewOrder(order);
        return order.getTotalPrice();
    }

    @GetMapping(path = "/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<GetOrderDto> getOrdersFromCustomerId(@PathVariable String userId){
        ValidationUtil.doesUserExist(userId,customerService);
        //return orderService.getAllOrders(UUID.fromString(userId));
        return orderMapper.mapListOrderToListGetOrderDto(customerService.getCustomer(userId).getOrders());
    }
}
