package com.dinellipaulo.userregister.services;

import com.dinellipaulo.userregister.entities.User;
import com.dinellipaulo.userregister.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }
}
