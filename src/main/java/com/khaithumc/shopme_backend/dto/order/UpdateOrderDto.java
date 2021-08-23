package com.khaithumc.shopme_backend.dto.order;

import com.khaithumc.shopme_backend.enums.Status;

import javax.validation.constraints.NotNull;

public class UpdateOrderDto {
    private @NotNull Integer id;
    private @NotNull Status status;

    public UpdateOrderDto(Integer id, Status status) {
        this.id = id;
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
}
