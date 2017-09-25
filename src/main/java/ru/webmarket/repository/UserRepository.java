package ru.webmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.webmarket.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findById(Long id);
}
