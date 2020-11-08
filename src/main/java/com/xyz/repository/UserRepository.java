package com.xyz.repository;

import com.xyz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmailId(String emailId);
}
