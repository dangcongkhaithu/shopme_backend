package com.khaithumc.shopme_backend.repository;

import com.khaithumc.shopme_backend.model.Order;

import com.khaithumc.shopme_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository  extends JpaRepository<Order, Integer> {
    List<Order> findAllByUserOrderByCreatedDateDesc(User user);

}
