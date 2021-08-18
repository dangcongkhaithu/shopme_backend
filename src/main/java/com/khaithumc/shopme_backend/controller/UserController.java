package com.khaithumc.shopme_backend.controller;


import com.khaithumc.shopme_backend.dto.ResponseDto;
import com.khaithumc.shopme_backend.dto.user.SignInDto;
import com.khaithumc.shopme_backend.dto.user.SignInResponseDto;
import com.khaithumc.shopme_backend.dto.user.SignupDto;
import com.khaithumc.shopme_backend.enums.Role;
import com.khaithumc.shopme_backend.exceptions.AuthenticationFailException;
import com.khaithumc.shopme_backend.exceptions.CustomException;
import com.khaithumc.shopme_backend.model.User;
import com.khaithumc.shopme_backend.repository.UserRepository;
import com.khaithumc.shopme_backend.service.AuthenticationService;
import com.khaithumc.shopme_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public List<User> findAllUser(@RequestParam("token") String token) throws AuthenticationFailException {
        authenticationService.authenticate(token);
        return userRepository.findAll();
    }

    @PostMapping("/signUp")
    public ResponseDto Signup(@RequestBody SignupDto signupDto) throws CustomException {
        return userService.signUp(signupDto, Role.user);
    }

    //TODO token should be updated
    @PostMapping("/signIn")
    public SignInResponseDto Signup(@RequestBody SignInDto signInDto) throws CustomException {
        return userService.signIn(signInDto);
    }

//    @PostMapping("/updateUser")
//    public ResponseDto updateUser(@RequestParam("token") String token, @RequestBody UserUpdateDto userUpdateDto) {
//        authenticationService.authenticate(token);
//        return userService.updateUser(token, userUpdateDto);
//    }


//    @PostMapping("/createUser")
//    public ResponseDto updateUser(@RequestParam("token") String token, @RequestBody UserCreateDto userCreateDto)
//            throws CustomException, AuthenticationFailException {
//        authenticationService.authenticate(token);
//        return userService.createUser(token, userCreateDto);
//    }
}
