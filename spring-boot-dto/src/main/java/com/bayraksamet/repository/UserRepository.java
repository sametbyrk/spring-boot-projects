package com.bayraksamet.repository;

import com.bayraksamet.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByEmailIgnoreCase(String email);

    List<User> findByNameContainingIgnoreCase(String name);
}
