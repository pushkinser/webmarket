package ru.webmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.webmarket.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(Long id);

    User findByUserName (String username);

    User findByEmail (String email);
}
