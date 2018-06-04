package com.tas.app.util;

import com.tas.app.model.Customer;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladimir Vashchuk on 31.05.2018
 */
public class CustomerTestUtil {
    private static final String DEFAULT_NAME_PATTERN = "newCustomer%d";
    private static final String DEFAULT_MAIL_PATTERN = "mail%d@mail.com";
    private static final Long DEFAULT_ID = 1L;

    private CustomerTestUtil() {
    }

    public static Customer buildCustomer(String name, String email, String phone) {
        return buildCustomer(null, name, email, phone);
    }

    public static Customer buildCustomer(Long id, String name, String email, String phone) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);
        return customer;
    }

    public static Customer buildDefaultCustomer() {
        return buildCustomer(
                String.format(DEFAULT_NAME_PATTERN, DEFAULT_ID),
                String.format(DEFAULT_MAIL_PATTERN, DEFAULT_ID),
                StringUtils.repeat(String.valueOf(DEFAULT_ID), 10)
        );
    }

    public static Customer buildDefaultCustomerWithId(Long id) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(String.format(DEFAULT_NAME_PATTERN, id));
        customer.setEmail(String.format(DEFAULT_MAIL_PATTERN, id));
        customer.setPhone(StringUtils.repeat(String.valueOf(id), 10));
        return customer;
    }

    public static List<Customer> buildCustomerList(int size) {
        List<Customer> customers = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            customers.add(buildDefaultCustomerWithId((long) i));
        }
        return customers;
    }
}
