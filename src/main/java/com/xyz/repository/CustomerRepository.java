package com.xyz.repository;

import com.xyz.entity.Customer;
import com.xyz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
