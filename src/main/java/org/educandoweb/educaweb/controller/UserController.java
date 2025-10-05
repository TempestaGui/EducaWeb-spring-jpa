package org.educandoweb.educaweb.controller;


import org.educandoweb.educaweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.educandoweb.educaweb.entity.User;

import java.util.List;

@RestController
@RequestMapping(value = "/Users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = userService.findAll();

        return ResponseEntity.ok().body(list);
    }

}
