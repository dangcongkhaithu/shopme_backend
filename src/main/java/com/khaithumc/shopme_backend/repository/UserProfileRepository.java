package com.khaithumc.shopme_backend.repository;

import com.khaithumc.shopme_backend.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    UserProfile findUserProfileByUserId(Integer userId);
}
