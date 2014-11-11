package com.phosphene.rest.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phosphene.rest.models.User;
import com.phosphene.rest.repository.UserRepository;

@Service
public class UserAccountService {

    @Autowired
    protected UserRepository userRepository;

    public User getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return user;
    }


    public User findById(Long id) {
        User user = userRepository.findOne(id);
        return user;
    }


}
