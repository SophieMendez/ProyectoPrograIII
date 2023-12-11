package com.api.api.controllers;

import com.api.api.User;
import com.api.api.services.DatabaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private DatabaseService databaseService;

    @GetMapping("/all")
    public List<User> allUsers() {
        return databaseService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return databaseService.getUserById(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable int id, @RequestParam String username, @RequestParam String password) {
        User user = new User(id, username, password);
        databaseService.updateUser(user);
    }

 @PostMapping
public void insertUser(@RequestParam String username, @RequestParam String password) {
    User user = new User(0, username, password);
    databaseService.insertUser(user);
}


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        databaseService.deleteUser(id);
    }
}
