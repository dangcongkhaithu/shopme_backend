package com.khaithumc.shopme_backend.model;

import com.khaithumc.shopme_backend.dto.user.UserProfileDto;

import javax.persistence.*;

@Entity
@Table(name="user_profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public UserProfile() {}

    public UserProfile(Integer id, String phone, String address) {
        this.id = id;
        this.phone = phone;
        this.address = address;
    }

    public  UserProfile(UserProfileDto userProfileDto, User user) {
        this.phone = userProfileDto.getPhone();
        this.address = userProfileDto.getAddress();
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public User getUser() {
        return user;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
