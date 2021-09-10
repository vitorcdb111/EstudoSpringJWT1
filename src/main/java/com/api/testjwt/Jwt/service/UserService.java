package com.api.testjwt.Jwt.service;

import com.api.testjwt.Jwt.model.UserModel;
import com.api.testjwt.Jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    private UserRepository repository;

    public UserModel saveUser(UserModel userModel)
    {
        return repository.save(userModel);
    }

//    public UserModel loginUser(UserModel userModel)
//    {
//        //to do
//        return
//    }

}
