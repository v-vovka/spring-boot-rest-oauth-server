package com.tas.app.service;

import com.tas.app.model.Customer;

import java.util.List;

/**
 * Created by Vladimir Vashchuk on 31.05.2018
 */
public interface CustomerService {

    List<Customer> findAll(String search);

    Customer findById(Long customerId);

    void save(Customer customer);

    void deleteById(Long customerId);
}
