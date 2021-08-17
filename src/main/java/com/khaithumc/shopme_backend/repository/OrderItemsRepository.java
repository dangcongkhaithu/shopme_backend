package com.khaithumc.shopme_backend.repository;


import com.khaithumc.shopme_backend.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepository extends JpaRepository<OrderItem,Integer> {
}
