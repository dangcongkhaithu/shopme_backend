package com.khaithumc.shopme_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.khaithumc.shopme_backend.dto.order.AddOrderDto;
import com.khaithumc.shopme_backend.dto.order.OrderDto;
import com.khaithumc.shopme_backend.enums.Status;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "created_date")
    private Date createdDate;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderItem> orderItems;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "shipping_info_id", referencedColumnName = "id")
    private ShippingInfo shippingInfo;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order(Integer id, Status status, double totalPrice, Date createdDate, List<OrderItem> orderItems, User user, ShippingInfo shippingInfo) {
        this.id = id;
        this.status = status;
        this.totalPrice = totalPrice;
        this.createdDate = createdDate;
        this.orderItems = orderItems;
        this.user = user;
        this.shippingInfo = shippingInfo;
    }

    public Order(OrderDto orderDto, User user, ShippingInfo shippingInfo) {
        this.shippingInfo = shippingInfo;
        this.user = user;
        this.createdDate = new Date();
        this.totalPrice = orderDto.getTotalPrice();
        this.status = orderDto.getStatus();
    }

    public Order() {

    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public ShippingInfo getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(ShippingInfo shippingInfo) {
        this.shippingInfo = shippingInfo;
    }
}
