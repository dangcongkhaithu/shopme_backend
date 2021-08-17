package com.khaithumc.shopme_backend.dto.user;


import com.khaithumc.shopme_backend.enums.Role;

public class UserCreateDto {

    private String email;
    private Role role;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
