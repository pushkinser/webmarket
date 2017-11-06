package ru.webmarket.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.webmarket.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName (String username);

}
