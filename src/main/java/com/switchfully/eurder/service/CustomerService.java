package com.switchfully.eurder.service;

import com.switchfully.eurder.domain.Order;
import com.switchfully.eurder.domain.User;
import com.switchfully.eurder.domain.UserRepository;
import com.switchfully.eurder.infrastructure.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {
    private final UserRepository userRepository;


    @Autowired
    public CustomerService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
}
