package com.xyz.services;

import com.xyz.common.ActiveStatus;
import com.xyz.common.Constants;
import com.xyz.entity.Customer;
import com.xyz.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    /*
     * if isVerified is true,updating activation status to activate
     */
    public String activateCustomer(long customerid) {

        Customer customer = customerRepository.findById(customerid).orElse(null);
        if(customer != null) {
           if(customer.isVerified()) {
               customer.setActivationStatus(ActiveStatus.ACTIVE.name());
               customerRepository.save(customer);
               return Constants.STATUS_SUCCESS;
           }
        }
        return Constants.STATUS_PENDING;
    }

}
