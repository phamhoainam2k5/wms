package com.example.wms.service;


import com.example.wms.entity.Roles;
import com.example.wms.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService {
    @Autowired
    private RolesRepository rolesRepository;

    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }

    public Optional<Roles> getRoleById(Integer id) {
        return rolesRepository.findById(id);
    }

    public Roles createRole(Roles role) {
        return rolesRepository.save(role);
    }

    public Roles updateRole(Integer id, Roles roleDetails) {
        Roles role = rolesRepository.findById(id).orElseThrow();
        role.setRoleLevel(roleDetails.getRoleLevel());
        return rolesRepository.save(role);
    }

    public void deleteRole(Integer id) {
        rolesRepository.deleteById(id);
    }
}