package com.khaithumc.shopme_backend.repository;


import com.khaithumc.shopme_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAll();

    User findByEmail(String email);

    User findById(int id);

    User findUserByEmail(String email);
}
