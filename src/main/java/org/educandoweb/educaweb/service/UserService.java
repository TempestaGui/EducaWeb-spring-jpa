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

    public User Insert(User user){
        return userRepository.save(user);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }

    public User update(Long id, User userNovo){
        User entity = userRepository.getReferenceById(id);
        updateData(entity, userNovo);
        return userRepository.save(entity);
    }

    private void updateData(User entity, User userNovo){
        entity.setName(userNovo.getName());
        entity.setEmail(userNovo.getEmail());
        entity.setPhone(userNovo.getPhone());
    }
}
