package com.switchfully.eurder.service;

import com.switchfully.eurder.domain.User;
import com.switchfully.eurder.domain.CustomerRepository;
import com.switchfully.eurder.infrastructure.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;


    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addNewCustomer(User user) {
        customerRepository.addNewCustomer(user);
    }

    public List<User> getCustomers() {
        return customerRepository.getCustomers();
    }

    public User getCustomer(String identifier) {
        ValidationUtil.isValidUuidFormat(identifier);
        ValidationUtil.doesUserExist(identifier,this);
        UUID id = UUID.fromString(identifier);
        return customerRepository.getUserByID(id);
    }

    public boolean doesUserExist(UUID id) {
        return customerRepository.doesUserExist(id);
    }

    public HashMap<UUID,User> getHashmapOfUsers() {
        return customerRepository.getHashMapOfUsers();
    }
}
