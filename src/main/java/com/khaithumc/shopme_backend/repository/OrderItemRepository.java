package com.khaithumc.shopme_backend.repository;

import com.khaithumc.shopme_backend.model.Order;
import com.khaithumc.shopme_backend.model.OrderItem;
import com.khaithumc.shopme_backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    List<OrderItem> findOrderItemByOrder(Order order);

}
