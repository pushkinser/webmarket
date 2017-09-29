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
        roleRepository.save(role);
    }

    @Override
    public RoleDTO getRole(Long id) {
        Role role = roleRepository.findOne(id);
        return RoleConvector.entityToDto(role);
    }

    @Override
    public void editRole(RoleDTO roleDTO) {
        Role role = RoleConvector.dtoToEntity(roleDTO);
        role = roleRepository.findOne(role.getId());

        role.setName(roleDTO.getName());
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.delete(id);
    }

    @Override
    public List<RoleDTO> getAllRoles() {
        return RoleConvector.entityToDto(roleRepository.findAll());
    }


    @Override
    public RoleDTO findByName(String name) {
        Role role = roleRepository.findByName(name);

        return RoleConvector.entityToDto(role);
    }
}
