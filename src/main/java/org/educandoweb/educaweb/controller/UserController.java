package org.educandoweb.educaweb.controller;


import org.educandoweb.educaweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.educandoweb.educaweb.entity.User;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = userService.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @PostMapping()
    public ResponseEntity<User> insert(@RequestBody User user){
       user =  userService.Insert(user);
       URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id") //para que retorne 201 create
               .buildAndExpand(user.getId()).toUri();
       return ResponseEntity.created(uri).body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(
            @PathVariable Long id,
            @RequestBody User user){
        user = userService.update(id, user);
        return ResponseEntity.ok().body(user);
    }


}
