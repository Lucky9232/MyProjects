package com.hibernate.mapping.contoller;

import com.hibernate.mapping.service.Impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
public class EmployeeController {

    @Autowired
    UserDetailsService userDetailsService;


    @Autowired
    UserService userService;

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String getEmployees() {

        //return userService.read();
        return "welcome user authentication done";
    }
}