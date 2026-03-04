package com.example.wms.controller;

import com.example.wms.entity.Roles;
import com.example.wms.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    private RolesRepository rolesRepository;

    @GetMapping
    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }

    @PostMapping
    public Roles createRole(@RequestBody Roles role) {
        return rolesRepository.save(role);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Roles> getRoleById(@PathVariable Integer id) {
        return rolesRepository.findById(id)
                .map(role -> ResponseEntity.ok(role))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Roles> updateRole(@PathVariable Integer id, @RequestBody Roles roleDetails) {
        return rolesRepository.findById(id)
                .map(role -> {
                    role.setRoleLevel(roleDetails.getRoleLevel());
                    return ResponseEntity.ok(rolesRepository.save(role));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRole(@PathVariable Integer id) {
        return rolesRepository.findById(id)
                .map(role -> {
                    rolesRepository.delete(role);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}