package com.switchfully.eurder.api.Dtos.Order;

import com.switchfully.eurder.domain.Order;
import com.switchfully.eurder.infrastructure.utils.ValidationUtil;
import com.switchfully.eurder.service.CustomerService;
import com.switchfully.eurder.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    final static Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    public OrderController(OrderService orderService, OrderMapper orderMapper, CustomerService customerService) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
        this.customerService = customerService;
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public float createOrder(@RequestBody CreateOrderDto createOrderDto, @RequestHeader ("UserID") String userID){
        logger.info("Received a request to create an order from : "+userID);
        Order order = orderMapper.mapCreateOrderDtoToOrder(createOrderDto);
        //orderService.addNewOrder(order);
        ValidationUtil.doesUserExist(userID,customerService);
        customerService.addOrderToCustomer(userID,order);
        return order.getTotalPrice();
    }

    @GetMapping(path = "/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<GetOrderDto> getOrdersFromCustomerId(@PathVariable String userId){
        logger.info("Received a request to get all the orders from this customer : "+userId);
        ValidationUtil.doesUserExist(userId,customerService);
        //return orderService.getAllOrders(UUID.fromString(userId));
        return orderMapper.mapListOrderToListGetOrderDto(customerService.getCustomer(userId).getOrders());
    }
}
