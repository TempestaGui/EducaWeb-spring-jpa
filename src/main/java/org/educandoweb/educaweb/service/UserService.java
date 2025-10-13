package org.educandoweb.educaweb.service;

import jakarta.persistence.EntityNotFoundException;
import org.educandoweb.educaweb.entity.User;
import org.educandoweb.educaweb.repository.UserRepository;
import org.educandoweb.educaweb.service.exception.DataBaseException;
import org.educandoweb.educaweb.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        User result = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
        if(result == null){
            throw new IllegalArgumentException("User not found");
        }
        return result;
    }

    public User Insert(User user){
        return userRepository.save(user);
    }

    public void delete(Long id){
        try {
            userRepository.deleteById(id);
        }
        catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
    }

    public User update(Long id, User userNovo){
        try{
            User entity = userRepository.getReferenceById(id);
            updateData(entity, userNovo);
            return userRepository.save(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User userNovo){
        entity.setName(userNovo.getName());
        entity.setEmail(userNovo.getEmail());
        entity.setPhone(userNovo.getPhone());
    }
}
