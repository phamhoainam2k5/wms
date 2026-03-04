package com.example.wms.service;


import com.example.wms.entity.Users;
import com.example.wms.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Optional<Users> getUserById(String id) {
        return usersRepository.findById(id);
    }

    public Users createUser(Users user) {
        return usersRepository.save(user);
    }

    public Users updateUser(String id, Users userDetails) {
        Users user = usersRepository.findById(id).orElseThrow();
        user.setName(userDetails.getName());
        user.setPassword(userDetails.getPassword());
        user.setEmployeeId(userDetails.getEmployeeId());
        return usersRepository.save(user);
    }

    public void deleteUser(String id) {
        usersRepository.deleteById(id);
    }
}