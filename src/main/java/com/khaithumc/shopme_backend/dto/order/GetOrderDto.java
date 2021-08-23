package com.khaithumc.shopme_backend.dto.order;

import com.khaithumc.shopme_backend.enums.Status;
import com.khaithumc.shopme_backend.model.*;

import javax.validation.constraints.NotNull;
import java.util.List;

public class GetOrderDto {
    private Integer id;
    private @NotNull ShippingInfo shippingInfo;
    private @NotNull List<OrderItem> orderItems;
    private @NotNull Status status;
    private @NotNull double totalPrice;


    public GetOrderDto(Order order, List<OrderItem> orderItems, ShippingInfo shippingInfo) {
        this.orderItems = orderItems;
        this.shippingInfo = shippingInfo;
        this.status = order.getStatus();
        this.totalPrice = order.getTotalPrice();
        this.id = order.getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ShippingInfo getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(ShippingInfo shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
