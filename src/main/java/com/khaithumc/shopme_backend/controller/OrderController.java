package com.khaithumc.shopme_backend.controller;

import com.khaithumc.shopme_backend.common.ApiResponse;
import com.khaithumc.shopme_backend.dto.order.AddOrderDto;
import com.khaithumc.shopme_backend.dto.order.GetOrderDto;
import com.khaithumc.shopme_backend.dto.order.UpdateOrderDto;
import com.khaithumc.shopme_backend.dto.user.UserProfileDto;
import com.khaithumc.shopme_backend.exceptions.AuthenticationFailException;
import com.khaithumc.shopme_backend.exceptions.OrderNotFoundException;
import com.khaithumc.shopme_backend.exceptions.ProductNotExistException;
import com.khaithumc.shopme_backend.model.Cart;
import com.khaithumc.shopme_backend.model.Order;
import com.khaithumc.shopme_backend.model.User;
import com.khaithumc.shopme_backend.repository.CartRepository;
import com.khaithumc.shopme_backend.service.AuthenticationService;
import com.khaithumc.shopme_backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> placeOrder(@RequestParam("token") String token)
            throws ProductNotExistException, AuthenticationFailException {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        orderService.placeOrder(user);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Order has been placed"), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<GetOrderDto>> getAllOrderOfUser(@RequestParam("token") String token) throws AuthenticationFailException {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        List<GetOrderDto> orderDtoList = orderService.listOrders(user);
        return new ResponseEntity<List<GetOrderDto>>(orderDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOrderOfUser(@PathVariable("id") Integer id, @RequestParam("token") String token) throws AuthenticationFailException {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        try {
            GetOrderDto order = orderService.getOrder(id, user);
            return new ResponseEntity<>(order, HttpStatus.OK);
        } catch (OrderNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/all")
    public ResponseEntity<List<GetOrderDto>> getAllOrders(@RequestParam("token") String token) throws AuthenticationFailException {
        authenticationService.authenticate(token);
        List<GetOrderDto> orderDtoList = orderService.getAllOrders();
        return new ResponseEntity<List<GetOrderDto>>(orderDtoList, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse> updateStatus(@RequestParam("token") String token, @RequestBody UpdateOrderDto updateOrderDto) {
        authenticationService.authenticate(token);
        orderService.updateStatus(updateOrderDto);
        return new ResponseEntity<>(new ApiResponse(true, "Update success"), HttpStatus.CREATED);
    }

}
