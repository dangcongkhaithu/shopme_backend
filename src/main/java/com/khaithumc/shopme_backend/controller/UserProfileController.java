package com.khaithumc.shopme_backend.controller;

import com.khaithumc.shopme_backend.common.ApiResponse;
import com.khaithumc.shopme_backend.dto.product.ProductDto;
import com.khaithumc.shopme_backend.dto.user.UserProfileDto;
import com.khaithumc.shopme_backend.model.User;
import com.khaithumc.shopme_backend.model.UserProfile;
import com.khaithumc.shopme_backend.service.AuthenticationService;
import com.khaithumc.shopme_backend.service.UserProfileService;
import com.khaithumc.shopme_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserService userService;

	/*@GetMapping("/")
	public ResponseEntity<List<UserProfile>> getUsers() {
		List<UserProfile> dtos = userProfileService.listProfiles();
		return new ResponseEntity<List<UserProfile>>(dtos, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<ApiResponse> addSurvey(@RequestBody @Valid UserProfile profile) {
		userProfileService.addProfile(profile);
		return new ResponseEntity<>(new ApiResponse(true, "Profile has been created."), HttpStatus.CREATED);
	}	*/

    @GetMapping("/{token}")
    public ResponseEntity<UserProfile> getUserProfile(@PathVariable String token) {
        int userId = authenticationService.getUser(token).getId();
        UserProfile userProfile = userProfileService.findUserProfileByUserId(userId);

        return new ResponseEntity<UserProfile>(userProfile, HttpStatus.OK);
    }

    @PutMapping("/update/{token}")
    public ResponseEntity<ApiResponse> updateProfile(@RequestBody @Valid UserProfileDto userProfileDto, @PathVariable String token) {
        int userId = authenticationService.getUser(token).getId();
        User user = userService.findUserById(userId);
        userProfileService.updateUserProfile(userId, userProfileDto, user);
        return new ResponseEntity<>(new ApiResponse(true, "Profile has been created."), HttpStatus.CREATED);
    }
}
