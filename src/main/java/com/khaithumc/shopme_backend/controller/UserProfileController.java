package com.khaithumc.shopme_backend.controller;

import com.khaithumc.shopme_backend.common.ApiResponse;
import com.khaithumc.shopme_backend.model.UserProfile;
import com.khaithumc.shopme_backend.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserProfileController {

	@Autowired private UserProfileService userProfileService;

	@GetMapping("/")
	public ResponseEntity<List<UserProfile>> getUsers() {
		List<UserProfile> dtos = userProfileService.listProfiles();
		return new ResponseEntity<List<UserProfile>>(dtos, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<ApiResponse> addSurvey(@RequestBody @Valid UserProfile profile) {
		userProfileService.addProfile(profile);
		return new ResponseEntity<>(new ApiResponse(true, "Profile has been created."), HttpStatus.CREATED);
	}	
}
