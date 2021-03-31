package com.switchfully.eurder.api.Dtos.Customer;

import com.switchfully.eurder.api.Dtos.Customer.CreateCustomerDto;
import com.switchfully.eurder.api.Dtos.Customer.CustomerDto;
import com.switchfully.eurder.api.Dtos.Customer.CustomerMapper;
import com.switchfully.eurder.infrastructure.utils.ValidationUtil;
import com.switchfully.eurder.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerController(CustomerService customerService, CustomerMapper customerMapper, CustomerMapper customerMapper1) {
        this.customerService = customerService;
        this.customerMapper = customerMapper1;
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestBody CreateCustomerDto createCustomerDTO) {
        customerService.addNewCustomer(customerMapper.mapCreateCustomerDtoToCustomer(createCustomerDTO));
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDto> getCustomers(@RequestHeader("Authorization") String userId) {
        ValidationUtil.hasAdminRights(userId,customerService);
        return customerMapper.mapToDtoList(customerService.getCustomers());
    }
    @GetMapping(path = "/{id}",produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto getCustomer(@RequestHeader("Authorization") String userId, @PathVariable String id) {
        ValidationUtil.hasAdminRights(userId,customerService);
        return customerMapper.mapToDto(customerService.getCustomer(id));
    }



}
