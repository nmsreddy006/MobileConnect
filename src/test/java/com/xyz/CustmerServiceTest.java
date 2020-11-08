package com.xyz;

import com.xyz.common.Constants;
import com.xyz.entity.Customer;
import com.xyz.repository.CustomerRepository;
import com.xyz.services.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class CustmerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void customerActivationTest_success() {
        final long customerId = 1l;
        final Customer customer = new Customer();
        customer.setActivationStatus("PENDING");
        customer.setActivePlan("default");
        customer.setCreatedDate(LocalDateTime.now());
        customer.setCustomerId(customerId);
        customer.setDocumentNumber("1111");
        customer.setFirstName("joe");
        customer.setVerified(true);
        given(customerRepository.findById(customerId)).willReturn(Optional.of(customer));
        final String status = customerService.activateCustomer(customerId);
        assertEquals(Constants.STATUS_SUCCESS,status);
    }

    @Test
    void customerActivationTest_pending() {
        final long customerId = 1l;
        final Customer customer = new Customer();
        customer.setActivationStatus("PENDING");
        customer.setActivePlan("default");
        customer.setCreatedDate(LocalDateTime.now());
        customer.setCustomerId(customerId);
        customer.setDocumentNumber("1111");
        customer.setFirstName("joe");
        customer.setVerified(false);
        given(customerRepository.findById(customerId)).willReturn(Optional.of(customer));
        final String status = customerService.activateCustomer(customerId);
        assertEquals(Constants.STATUS_PENDING,status);
    }
}
