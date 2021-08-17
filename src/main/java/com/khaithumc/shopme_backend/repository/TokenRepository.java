package com.khaithumc.shopme_backend.repository;

import com.khaithumc.shopme_backend.model.AuthenticationToken;
import com.khaithumc.shopme_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<AuthenticationToken, Integer> {
    AuthenticationToken findTokenByUser(User user);
    AuthenticationToken findTokenByToken(String token);
}
