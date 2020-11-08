package com.xyz.controller;

import com.xyz.common.ActiveStatus;
import com.xyz.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("api/admin")
public class AdminController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String getCustomerDetails() {
        return "logged in";
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<String> getCustomerDetails(@PathVariable Long customerId) {
        String status = customerService.activateCustomer(customerId);
        if(status.equalsIgnoreCase(ActiveStatus.ACTIVE.name())) {
            return new ResponseEntity<String>
                    ("Customer Activated", HttpStatus.OK);
        }else{
            return new ResponseEntity<String>
                    ("Customer is not Activated", HttpStatus.OK);
        }
    }
}
