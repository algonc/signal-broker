package com.test.signal.broker.service;

import com.test.signal.broker.model.User;

import java.util.List;

public interface IdentityService {

    User findByUsername(String username);

    List<User> findAllUsers();
    
}
