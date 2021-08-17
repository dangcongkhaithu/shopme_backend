package com.khaithumc.shopme_backend.service;

import com.khaithumc.shopme_backend.model.UserProfile;
import com.khaithumc.shopme_backend.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileService {

	@Autowired private UserProfileRepository userRepo;
	

	public void addProfile(UserProfile userProfile) {
		userRepo.save(userProfile);
	}
	
	public List<UserProfile> listProfiles(){
		return userRepo.findAll();		
	}
	
}
