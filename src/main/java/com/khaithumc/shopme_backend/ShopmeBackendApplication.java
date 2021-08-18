package com.khaithumc.shopme_backend;

import com.khaithumc.shopme_backend.dto.user.SignupDto;
import com.khaithumc.shopme_backend.enums.Role;
import com.khaithumc.shopme_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopmeBackendApplication /*implements CommandLineRunner*/ {

   /* @Autowired
    private UserService userService;*/

    public static void main(String[] args) {
        SpringApplication.run(ShopmeBackendApplication.class, args);
    }

    /*@Override
    public void run(String... args) throws Exception {
        SignupDto signupDto = new SignupDto();
        signupDto.setEmail("admin@gmail.com");
        signupDto.setPassword("admin");

        userService.signUp(signupDto, Role.admin);
    }*/
}
