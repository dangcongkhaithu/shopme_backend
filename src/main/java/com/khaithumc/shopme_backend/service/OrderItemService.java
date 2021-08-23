package com.khaithumc.shopme_backend.service;

import com.khaithumc.shopme_backend.model.Order;
import com.khaithumc.shopme_backend.model.OrderItem;
import com.khaithumc.shopme_backend.model.Product;
import com.khaithumc.shopme_backend.repository.OrderItemRepository;
import com.khaithumc.shopme_backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductRepository productRepository;

    public void addOrderProduct(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }

    public List<OrderItem> getOrderItems(Order order) {
        return orderItemRepository.findOrderItemByOrder(order);
    }

}
