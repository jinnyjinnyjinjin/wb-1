package com.example.layeredarchitecture.application.service.user;

import com.example.layeredarchitecture.domain.cart.CartService;
import com.example.layeredarchitecture.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSignupService {

    private final UserService userService;
    private final CartService cartService;

    public void signup(String name) {
        Long userId = userService.create(name);
        cartService.createCart(userId);
    }
}
