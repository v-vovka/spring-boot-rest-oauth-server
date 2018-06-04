package com.tas.app.controller;

import com.tas.app.model.Customer;
import com.tas.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Vladimir Vashchuk on 30.05.2018
 */

@RestController
@RequestMapping("/secured/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> getAll(@RequestParam(value = "search", required = false) String search) {
        return service.findAll(search);
    }

    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    public Customer getOne(@PathVariable Long customerId) {
        return service.findById(customerId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@Validated @RequestBody Customer customer) {
        service.save(customer);
    }

    /*@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@Validated @RequestBody Customer customer) {
        Long savedId = service.save(customer);
        return ResponseEntity
                .status(HttpStatus.CREATED).body("id: " + savedId);
    }*/

    @RequestMapping(value = "/{customerId}", method = RequestMethod.PUT)
    public void update(@Validated @RequestBody Customer customer, @PathVariable Long customerId) {
        customer.setId(customerId);
        service.save(customer);
    }

    @RequestMapping(value = "/{customerId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long customerId) {
        service.deleteById(customerId);
    }
}
