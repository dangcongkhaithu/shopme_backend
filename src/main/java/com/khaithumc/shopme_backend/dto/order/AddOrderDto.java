package com.khaithumc.shopme_backend.dto.order;

import com.khaithumc.shopme_backend.dto.cart.CartDto;
import com.khaithumc.shopme_backend.enums.Status;
import com.khaithumc.shopme_backend.model.Cart;

import javax.validation.constraints.NotNull;
import java.util.List;

public class AddOrderDto {
    private Integer id;
    private @NotNull CartDto cartDto;
    private @NotNull Status status;

    public AddOrderDto(Integer id, @NotNull CartDto cartDto, @NotNull Status status) {
        this.id = id;
        this.cartDto = cartDto;
        this.status = status;
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

    public CartDto getCartDto() {
        return cartDto;
    }

    public void setCartDto(CartDto cartDto) {
        this.cartDto = cartDto;
    }
}
