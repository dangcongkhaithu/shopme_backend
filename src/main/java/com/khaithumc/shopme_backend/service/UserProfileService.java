package com.khaithumc.shopme_backend.service;

import com.khaithumc.shopme_backend.dto.user.UserProfileDto;
import com.khaithumc.shopme_backend.model.User;
import com.khaithumc.shopme_backend.model.UserProfile;
import com.khaithumc.shopme_backend.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userRepo;


   /* public void addProfile(UserProfile userProfile) {
        userRepo.save(userProfile);
    }

    public List<UserProfile> listProfiles() {
        return userRepo.findAll();
    }*/

    public static UserProfile getUserProfileFromDto(UserProfileDto userProfileDto, User user) {
        UserProfile userProfile = new UserProfile(userProfileDto, user);
        return userProfile;
    }

    public UserProfile findUserProfileByUserId(Integer userId) {
        return userRepo.findUserProfileByUserId(userId);
    }

    public void updateUserProfile(Integer userId, UserProfileDto userProfileDto, User user) {
        UserProfile userProfile = getUserProfileFromDto(userProfileDto, user);
        userProfile.setId(userId);
        userRepo.save(userProfile);
    }
}
