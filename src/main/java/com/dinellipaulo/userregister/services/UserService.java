package com.dinellipaulo.userregister.services;

import com.dinellipaulo.userregister.entities.User;
import com.dinellipaulo.userregister.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> findUsersById(Long id){
        return userRepository.findById(id);
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails){
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            User u = user.get();
            u.setName(userDetails.getName());
            u.setEmail(userDetails.getEmail());
            return userRepository.save(u);
        }
        return null;
        //TODO: Implement exception handler method if user is not found
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
