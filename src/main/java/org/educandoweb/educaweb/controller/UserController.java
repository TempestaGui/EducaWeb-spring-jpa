package org.educandoweb.educaweb.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.educandoweb.educaweb.entity.User;

@RestController
@RequestMapping(value = "/Users")
public class UserController {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L,"teste","teste@gmail","123","senha123");

        return ResponseEntity.ok().body(u);
    }

}
