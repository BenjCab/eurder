package com.switchfully.eurder.infrastructure.utils;

import com.switchfully.eurder.domain.Role;
import com.switchfully.eurder.service.CustomerService;
import com.switchfully.eurder.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class ValidationUtil {
    final static Logger logger = LoggerFactory.getLogger(ValidationUtil.class);

    public static void hasAdminRights(String identifier, CustomerService customerService){
        isValidUuidFormat(identifier);
        UUID id = UUID.fromString(identifier);
        doesUserExist(identifier,customerService);
        if(customerService.getHashmapOfUsers().get(id).getRole()!= Role.ADMIN){
            throw new IllegalArgumentException("You do not have admin rights.");
        }
    }

    public static void isValidUuidFormat(String identifier){
        //logger.info("Validating a UUID");
        if (identifier.length() != 36){
            throw new IllegalArgumentException("Wrong identifier format provided");
        }
    }

    public static void doesUserExist(String identifier, CustomerService customerService){
        UUID id = UUID.fromString(identifier);
        if (!customerService.doesUserExist(id)){
            throw new IllegalArgumentException("This identifier does not exist.");
        }
    }

    public static void throwExceptionIfNull(String data,String type){
        if(data == null || data.length()==0){
            throw new IllegalArgumentException("The "+type+" cannot be null.");
        }
    }
    public static void doesItemExist(String identifier, ItemService itemService){
        isValidUuidFormat(identifier);
        UUID id = UUID.fromString(identifier);
        if (!itemService.doesItemExist(id)){
            throw new IllegalArgumentException("There is no item with that ID.");
        }
    }
}
