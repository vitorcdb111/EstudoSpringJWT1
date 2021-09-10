package com.api.testjwt.Jwt.repository;

import com.api.testjwt.Jwt.model.UserModel;
import com.api.testjwt.Jwt.service.UserService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByUsername(String username);
}
