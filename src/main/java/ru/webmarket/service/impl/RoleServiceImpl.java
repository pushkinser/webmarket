package ru.webmarket.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.webmarket.entity.Role;
import ru.webmarket.entity.converter.RoleConverter;
import ru.webmarket.entity.dto.RoleDTO;
import ru.webmarket.repository.RoleRepository;
import ru.webmarket.service.RoleService;

import java.util.List;

/*

 */

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void addRole(RoleDTO roleDTO) {
        Role role = RoleConverter.dtoToEntity(roleDTO);
        if (role != null) roleRepository.save(role);
    }

    @Override
    public RoleDTO getRole(Long id) {
        return RoleConverter.entityToDto(roleRepository.findOne(id));
    }

    @Override
    public void editRole(RoleDTO roleDTO) {
        Role role = RoleConverter.dtoToEntity(roleDTO);
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
    public List<RoleDTO> getRoles() {
        return RoleConverter.entityToDto(roleRepository.findAll());
    }


    @Override
    public RoleDTO findByName(String name) {
        return RoleConverter.entityToDto(roleRepository.findByName(name));
    }
}
