package com.api.testjwt.Jwt.controller;

import com.api.testjwt.Jwt.model.UserDTO;
import com.api.testjwt.Jwt.model.UserModel;
import com.api.testjwt.Jwt.service.UserService;
import com.api.testjwt.Jwt.config.Configuration;
import com.fasterxml.jackson.annotation.JacksonInject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService service;

    private BCryptPasswordEncoder bcryptPasswordEncoder;

    @PostMapping(value = "/save")
    public UserModel saveUser(@RequestBody UserModel userModel)
    {
        return service.saveUser(userModel);
    }

//    @PostMapping(value = "/login")
//    public UserModel LoginUser(@RequestBody UserModel userModel)
//    {
//        return service.loginUser(userModel);
//    }

    @Transactional(rollbackFor = Exception.class)
    public String saveDTO(UserDTO userDTO)
    {
        userDTO.setPassword(bcryptPasswordEncoder.encode(userDTO.getPassword()));
        return saveUser(new UserModel(userDTO)).getUsername();
    }
}
