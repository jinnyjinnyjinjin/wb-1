package com.example.layeredarchitecture.domain.cart;

import com.example.layeredarchitecture.application.service.cart.dto.CartItemDto;
import com.example.layeredarchitecture.domain.cart.entity.Cart;
import com.example.layeredarchitecture.domain.cart.entity.CartItem;
import com.example.layeredarchitecture.domain.item.ItemReader;
import com.example.layeredarchitecture.domain.item.OptionReader;
import com.example.layeredarchitecture.domain.item.entity.Item;
import com.example.layeredarchitecture.domain.item.entity.Option;
import com.example.layeredarchitecture.domain.user.User;
import com.example.layeredarchitecture.domain.user.UserReader;
import com.example.layeredarchitecture.infra.CartItemRepository;
import com.example.layeredarchitecture.infra.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final UserReader userReader;
    private final ItemReader itemReader;
    private final CartReader cartReader;
    private final OptionReader optionReader;
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;

    @Transactional
    public void addItem(CartItemDto item) {
        Cart cart = cartReader.readByUserId(item.getUserId());
        cart.getCartItems().stream()
                .filter(cartItem -> cartItem.hasSameOptionItem(item.getItemId(), item.getOptionId()))
                .findFirst()
                .ifPresentOrElse(
                        cartItem -> cartItem.increaseQuantity(item.getQuantity()),
                        () -> {
                            Item newItem = itemReader.readById(item.getItemId());
                            Option option = optionReader.readById(item.getOptionId());
                            CartItem cartItem = CartItem.create(cart, newItem, option, item.getQuantity());
                            cartItemRepository.save(cartItem);
                            cart.addItem(cartItem);
                        }
                );
    }

    public void createCart(Long userId) {
        User user = userReader.readById(userId);
        Cart cart = Cart.create(user);
        cartRepository.save(cart);
    }
}
