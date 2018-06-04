package com.tas.app.service;

import com.tas.app.model.Customer;
import com.tas.app.repository.CustomerRepository;
import com.tas.app.repository.spec.CustomerSpecificationsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Vladimir Vashchuk on 30.05.2018
 */

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    @PreAuthorize("hasAuthority('CUSTOMER_READ')")
    public List<Customer> findAll(String search) {
        CustomerSpecificationsBuilder builder = new CustomerSpecificationsBuilder();
        Pattern pattern = Pattern.compile("(\\w+?)(:)([a-zA-Z0-9\\-]*),");
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }

        Specification<Customer> spec = builder.build();

        return repository.findAll(spec);
    }

    @Override
    @PreAuthorize("hasAuthority('CUSTOMER_READ')")
    public Customer findById(Long customerId) {
        Optional<Customer> customer = repository.findById(customerId);

        if (!customer.isPresent()) {
            throw new CustomerNotFoundException("id=" + customerId);
        }

        return customer.get();
    }

    @Override
    @PreAuthorize("hasAuthority('CUSTOMER_CREATE') and hasAuthority('CUSTOMER_UPDATE')")
    public void save(Customer customer) {
        repository.save(customer);
    }

    @Override
    @PreAuthorize("hasAuthority('CUSTOMER_DELETE')")
    public void deleteById(Long customerId) {
        repository.deleteById(customerId);
    }
}
