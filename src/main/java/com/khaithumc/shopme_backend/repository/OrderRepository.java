package com.khaithumc.shopme_backend.repository;

import com.khaithumc.shopme_backend.model.Cart;
import com.khaithumc.shopme_backend.model.Order;
import com.khaithumc.shopme_backend.model.OrderItem;
import com.khaithumc.shopme_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findAllByUserOrderByCreatedDateDesc(User user);

    Order findOrderById(int id);

}
