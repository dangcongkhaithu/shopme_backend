package com.khaithumc.shopme_backend.service;

import com.khaithumc.shopme_backend.dto.cart.CartDto;
import com.khaithumc.shopme_backend.dto.cart.CartItemDto;
import com.khaithumc.shopme_backend.dto.order.GetOrderDto;
import com.khaithumc.shopme_backend.dto.order.AddOrderDto;
import com.khaithumc.shopme_backend.dto.order.OrderDto;
import com.khaithumc.shopme_backend.dto.order.UpdateOrderDto;
import com.khaithumc.shopme_backend.enums.Status;
import com.khaithumc.shopme_backend.exceptions.OrderNotFoundException;
import com.khaithumc.shopme_backend.model.*;
import com.khaithumc.shopme_backend.repository.OrderRepository;
import com.khaithumc.shopme_backend.repository.ShippingInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private CartService cartService;

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private ShippingInfoRepository shippingInfoRepository;

    public Order saveOrder(OrderDto orderDto, User user, ShippingInfo shippingInfo) {
        Order order = new Order(orderDto, user, shippingInfo);
        return orderRepository.save(order);
    }

    public ShippingInfo saveShippingInfo(User user) {
        UserProfile userProfile = userProfileService.findUserProfileByUserId(user.getId());
        ShippingInfo shippingInfo = new ShippingInfo();
        shippingInfo.setFullName(userProfile.getFirstname() + " " + userProfile.getLastname());
        shippingInfo.setPhone(userProfile.getPhone());
        shippingInfo.setAddress(userProfile.getAddress());
        return shippingInfoRepository.save(shippingInfo);
    }

    public void placeOrder(User user) {
        CartDto cartDto = cartService.listCartItems(user);
        ShippingInfo shippingInfo = saveShippingInfo(user);

        OrderDto orderDto = new OrderDto();
        orderDto.setUser(user);
        orderDto.setTotalPrice(cartDto.getTotalCost());
        orderDto.setStatus(Status.ordered);
        orderDto.setShippingInfo(shippingInfo);


        Order newOrder = saveOrder(orderDto, user, shippingInfo);
        List<CartItemDto> cartItemDtoList = cartDto.getCartItems();
        for (CartItemDto cartItemDto : cartItemDtoList) {
            OrderItem orderItem = new OrderItem(newOrder, cartItemDto.getProduct(), cartItemDto.getQuantity(), cartItemDto.getProduct().getPrice());
            orderItemService.addOrderProduct(orderItem);
        }
        cartService.deleteUserCartItems(user);
    }

    public List<GetOrderDto> listOrders(User user) {
        List<Order> orderList = orderRepository.findAllByUserOrderByCreatedDateDesc(user);
        List<GetOrderDto> getOrderDtos = new ArrayList<>();
        for (Order order : orderList) {
            GetOrderDto getOrderDto = getDtoFromOrder(order, user);
            getOrderDtos.add(getOrderDto);
        }
        return getOrderDtos;
    }

    public GetOrderDto getOrder(int orderId, User user) throws OrderNotFoundException {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            return getDtoFromOrder(order, user);
        }
        throw new OrderNotFoundException("Order not found");
    }

    public List<GetOrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<GetOrderDto> getOrderDtoList = new ArrayList<>();
        for (Order order : orders) {
            GetOrderDto getOrderDto = getDtoFromOrder(order, order.getUser());
            getOrderDtoList.add(getOrderDto);
        }
        return getOrderDtoList;
    }

    public void updateStatus(UpdateOrderDto updateOrderDto) {
        Order order = orderRepository.findOrderById(updateOrderDto.getId());
        order.setStatus(updateOrderDto.getStatus());
    }

    public GetOrderDto getDtoFromOrder(Order order, User user) {
        List<OrderItem> orderItems = orderItemService.getOrderItems(order);
        ShippingInfo shippingInfo = shippingInfoRepository.findShippingInfoById(order.getShippingInfo().getId());
        GetOrderDto getOrderDto = new GetOrderDto(order, orderItems, shippingInfo);
        return getOrderDto;
    }


}
