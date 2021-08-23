package com.khaithumc.shopme_backend.repository;

import com.khaithumc.shopme_backend.model.Cart;
import com.khaithumc.shopme_backend.model.User;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findAllByUserOrderByCreatedDateDesc(User user);

    List<Cart> deleteByUser(User user);

    Cart findCartsById(int id);

}

