package com.khaithumc.shopme_backend.dto.order;

import com.khaithumc.shopme_backend.enums.Status;
import com.khaithumc.shopme_backend.model.Cart;
import com.khaithumc.shopme_backend.model.Order;
import com.khaithumc.shopme_backend.model.ShippingInfo;
import com.khaithumc.shopme_backend.model.User;

import javax.validation.constraints.NotNull;
import java.util.List;

public class OrderDto {
    private Integer id;
    private @NotNull User user;
    private @NotNull ShippingInfo shippingInfo;
    private @NotNull double totalPrice;
    private @NotNull Status status;

    public OrderDto(Order order) {
        this.id = order.getId();
        this.user = order.getUser();
        this.shippingInfo = order.getShippingInfo();
        this.totalPrice = order.getTotalPrice();
        this.status = order.getStatus();
    }

    public OrderDto() {

    }

    public ShippingInfo getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(ShippingInfo shippingInfo) {
        this.shippingInfo = shippingInfo;
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
