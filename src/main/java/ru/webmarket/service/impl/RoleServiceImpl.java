package ru.webmarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.webmarket.model.dto.RoleDTO;
import ru.webmarket.model.mapper.RoleMap;
import ru.webmarket.repository.RoleRepository;
import ru.webmarket.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /**
     * Возвращает роль по идентификатору.
     */
    @Override
    public RoleDTO get(Long id) {
        return RoleMap.toDto(roleRepository.findOne(id));
    }

    /**
     * Возвращает роль по фактическому названию.
     */
    @Override
    public RoleDTO get(String roleName) {
        return RoleMap.toDto(roleRepository.findByName(roleName));
    }
}
