package ru.webmarket.repository;

import org.springframework.data.repository.CrudRepository;
import ru.webmarket.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
