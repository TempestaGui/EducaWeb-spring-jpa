package org.educandoweb.educaweb.service;

import org.educandoweb.educaweb.entity.User;
import org.educandoweb.educaweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        User result = userRepository.findById(id).orElse(null);
        if(result == null){
            throw new IllegalArgumentException("User not found");
        }
        return result;
    }
}
