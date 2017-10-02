package ru.webmarket.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.webmarket.entity.Role;
import ru.webmarket.entity.User;
import ru.webmarket.entity.converter.RoleConvector;
import ru.webmarket.entity.dto.RoleDTO;
import ru.webmarket.entity.dto.UserDTO;
import ru.webmarket.repository.RoleRepository;
import ru.webmarket.service.RoleService;

import java.util.ArrayList;
import java.util.List;

/*

 */

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void addRole(RoleDTO roleDTO) {
        Role role = RoleConvector.dtoToEntity(roleDTO);
        if (role != null) roleRepository.save(role);
    }

    @Override
    public RoleDTO getRole(Long id) {
        Role role = roleRepository.findOne(id);
        if (role == null) return null;
        return RoleConvector.entityToDto(role);
    }

    @Override
    public void editRole(RoleDTO roleDTO) {
        Role role = RoleConvector.dtoToEntity(roleDTO);
        if (role != null) {
            role = roleRepository.findOne(role.getId());
            role.setName(roleDTO.getName());
        }
    }

    @Override
    public void deleteRole(Long id) {
        Role role = roleRepository.findOne(id);
        if (role != null) roleRepository.delete(id);
    }

    @Override
    public List<RoleDTO> getAllRoles() {
        List<RoleDTO> roleDTOS = new ArrayList<>();
        roleDTOS = RoleConvector.entityToDto(roleRepository.findAll());
        if (roleDTOS == null) return null;
        return roleDTOS;
    }


    @Override
    public RoleDTO findByName(String name) {
        Role role = roleRepository.findByName(name);
        if (role == null) return null;
        return RoleConvector.entityToDto(role);
    }
}
