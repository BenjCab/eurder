package com.switchfully.eurder.service;

import com.switchfully.eurder.api.Dtos.Order.GetItemGroupDto;
import com.switchfully.eurder.api.Dtos.Order.ItemGroupMapper;
import com.switchfully.eurder.api.Dtos.Order.TodayShippingDto;
import com.switchfully.eurder.domain.ItemGroup;
import com.switchfully.eurder.domain.Order;
import com.switchfully.eurder.domain.repositories.OrderRepository;
import com.switchfully.eurder.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerService customerService;

    @Autowired
    public OrderService(OrderRepository orderRepository, CustomerService customerService) {
        this.orderRepository = orderRepository;
        this.customerService = customerService;
    }

    //SHOULD NOT BE USED?
    public void addNewOrder(Order order) {
        orderRepository.addNewOrder(order);
    }

    public List<TodayShippingDto> getTodayShipping(UUID id, ItemGroupMapper itemGroupMapper) {
        List<TodayShippingDto> groupsShippedTodayByUser = new ArrayList<>();
        for (User user : customerService.getCustomers()) {
            List<GetItemGroupDto> userGroupShippedToday = new ArrayList<>();
            for (Order order : user.getOrders()) {
                for (ItemGroup itemGroup : order.getItemGroups()) {
                    if (itemGroup.getShippingDate().equals(LocalDate.now().plusDays(1))) { // set to 0 for actual code, one to test
                        userGroupShippedToday.add(itemGroupMapper.mapItemGroupToGetItemGroupDto(itemGroup));
                    }
                }
            }
            if (userGroupShippedToday.size() > 0) {
                groupsShippedTodayByUser.add(new TodayShippingDto(userGroupShippedToday, user.getAddress()));
            }
        }
        return groupsShippedTodayByUser;
    }
}
