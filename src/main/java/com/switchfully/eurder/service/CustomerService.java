package com.switchfully.eurder.service;

import com.switchfully.eurder.domain.*;
import com.switchfully.eurder.domain.repositories.UserRepository;
import com.switchfully.eurder.infrastructure.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {
    private final UserRepository userRepository;
    private final ItemService itemService;

    @Autowired
    public CustomerService(UserRepository userRepository, ItemService itemService) {
        this.userRepository = userRepository;
        this.itemService = itemService;
    }

    public void addNewCustomer(User user) {
        userRepository.addNewCustomer(user);
    }

    public List<User> getCustomers() {
        return userRepository.getCustomers();
    }

    public User getCustomer(String identifier) {
        ValidationUtil.isValidUuidFormat(identifier);
        ValidationUtil.doesUserExist(identifier,this);
        UUID id = UUID.fromString(identifier);
        return userRepository.getUserByID(id);
    }

    public boolean doesUserExist(UUID id) {
        return userRepository.doesUserExist(id);
    }

    public HashMap<UUID,User> getHashmapOfUsers() {
        return userRepository.getHashMapOfUsers();
    }

    public void addOrderToCustomer(String id, Order order) {
        getCustomer(id).addOrder(order);
    }

    public float redoOrder(String userId, String orderId) {
        Order oldOrder = userRepository.getUserByID(UUID.fromString(userId)).getOrderById(UUID.fromString(orderId));
        List<ItemGroup> newItems = new ArrayList<>();
        for(ItemGroup group : oldOrder.getItemGroups()){
            newItems.add(new ItemGroup(itemService.getItemRepository().getItemFromId(group.getItem().getUuid()),group.getAmount()));
        }
        Order newOrder = new Order(newItems);
        addOrderToCustomer(newOrder.getUuid().toString(),newOrder);
        return newOrder.getTotalPrice();
    }
}
