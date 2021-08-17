package com.khaithumc.shopme_backend.dto.order;

import com.khaithumc.shopme_backend.model.Order;
import com.khaithumc.shopme_backend.model.User;

import javax.validation.constraints.NotNull;

public class PlaceOrderDto {
    private Integer id;
    private @NotNull User user;
    private @NotNull Double totalPrice;

    public PlaceOrderDto() {
    }

    public PlaceOrderDto(Order order) {
        this.setId(order.getId());
        this.setUser(order.getUser());
        this.setTotalPrice(order.getTotalPrice());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
