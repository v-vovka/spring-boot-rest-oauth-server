package com.tas.app.controller;

import com.tas.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Vladimir Vashchuk on 30.05.2018
 */
@RestController
@RequestMapping("/secured/user")
public class UserController {

    @Autowired
    private CustomerService service;

    @RequestMapping(method = RequestMethod.GET)
    public Principal getPrincipal(Principal user) {
        return user;
    }
}
