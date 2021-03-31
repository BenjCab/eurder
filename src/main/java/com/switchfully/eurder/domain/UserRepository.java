package com.switchfully.eurder.domain;

import com.switchfully.eurder.api.Dtos.Order.OrderController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    private final HashMap<UUID, User> customerDatabase;

    public UserRepository() {
        this.customerDatabase = new HashMap<>();

        //hardcoded list of clients just for the exercice
        User c1 = new User("Ben","Cab","yop@yopmail.com","22 rue des paquerettes","0454015475");
        User c2 = new User("ali","bil","pop@yopmail.com","23 rue des paquerettes","0454320001");
        User c3 = new User("roger","Henin","sop@yopmail.com","24 rue des paquerettes","0454265489");

        UUID uuidDummyClient = UUID.fromString("234e4567-e89b-12d3-a456-556642440000");
        User c4 = new User("marcel","crrrrn","lkmp@yopmail.com","29 rue des paquerettes","0654265489",Role.CUSTOMER,uuidDummyClient);

        UUID uuidAdmin = UUID.fromString("123e4567-e89b-12d3-a456-556642440000");
        User admin = new User("roger","Henin","sop@yopmail.com","24 rue des paquerettes","0454265489",Role.ADMIN,uuidAdmin);
        customerDatabase.put(c1.getUuid(),c1);
        customerDatabase.put(c2.getUuid(),c2);
        customerDatabase.put(c3.getUuid(),c3);
        customerDatabase.put(admin.getUuid(),admin);
    }

    public void addNewCustomer(User user) {
        customerDatabase.put(user.getUuid(), user);
    }

    public List<User> getCustomers() {
        return new ArrayList<>(customerDatabase.values());
    }
    public User getUserByID(UUID uuid){
        return customerDatabase.get(uuid);
    }

    public boolean doesUserExist(UUID id) {
        return customerDatabase.containsKey(id);
    }

    public HashMap<UUID, User> getHashMapOfUsers() {
        return customerDatabase;
    }
}
