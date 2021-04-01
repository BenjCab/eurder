package com.switchfully.eurder.domain;

import com.switchfully.eurder.infrastructure.utils.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class User {
    final static Logger logger = LoggerFactory.getLogger(User.class);

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String address;
    private final String phoneNumber;
    private final UUID uuid;
    private final Role role;
    private final HashMap<UUID,Order> orders;

    public User(String firstName, String lastName, String email, String address, String phoneNumber) {
        ValidationUtil.throwExceptionIfNull(firstName,"first name");
        ValidationUtil.throwExceptionIfNull(lastName,"last name");
        ValidationUtil.throwExceptionIfNull(email,"email");
        ValidationUtil.throwExceptionIfNull(address,"address");
        ValidationUtil.throwExceptionIfNull(phoneNumber,"phone number");
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        uuid = UUID.randomUUID();
        role = Role.CUSTOMER;
        //orders = new ArrayList<>();
        orders = new HashMap<>();
    }
    //just to create admins
    public User(String firstName, String lastName, String email, String address, String phoneNumber, Role role, UUID uuid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.uuid = uuid;
        orders = new HashMap<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Role getRole() {
        return role;
    }

    public void addOrder(Order order){
        orders.put(order.getUuid(),order);
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders.values());
    }

    public Order getOrderById(UUID id) {
        if(!orders.containsKey(id)){
            logger.warn("This id ("+id+") does not represent an order from the client : "+this.getUuid());
            throw new IllegalArgumentException("This id ("+id+") does not represent an order from the client : "+this.getUuid());
        }
        return orders.get(id);
    }
}
