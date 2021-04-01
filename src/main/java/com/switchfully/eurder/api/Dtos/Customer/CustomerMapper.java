package com.switchfully.eurder.api.Dtos.Customer;

import com.switchfully.eurder.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    public User mapCreateCustomerDtoToCustomer(CreateCustomerDto createCustomerDto){
        return new User(
                createCustomerDto.getFirstName(),
                createCustomerDto.getLastName(),
                createCustomerDto.getEmail(),
                createCustomerDto.getAddress(),
                createCustomerDto.getPhoneNumber()
        );
    }

    public List<CustomerDto> mapToDtoList(List<User> users) {
        return users.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public CustomerDto mapToDto(User user) {
        return new CustomerDto(user.getFirstName(), user.getLastName(), user.getEmail());
    }
}
