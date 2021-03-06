package ru.webmarket.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.webmarket.model.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName (String name);

}
