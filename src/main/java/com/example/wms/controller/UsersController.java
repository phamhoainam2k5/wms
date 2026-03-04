package com.example.wms.controller;

import com.example.wms.entity.Users;
import com.example.wms.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @PostMapping
    public Users createUser(@RequestBody Users user) {
        return usersRepository.save(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable String id) {
        return usersRepository.findById(id)
                .map(user -> ResponseEntity.ok(user))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable String id, @RequestBody Users userDetails) {
        return usersRepository.findById(id)
                .map(user -> {
                    user.setName(userDetails.getName());
                    user.setPassword(userDetails.getPassword());
                    user.setEmployeeId(userDetails.getEmployeeId());
                    return ResponseEntity.ok(usersRepository.save(user));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable String id) {
        return usersRepository.findById(id)
                .map(user -> {
                    usersRepository.delete(user);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}