package com.example.layeredarchitecture.domain.cart;

import com.example.layeredarchitecture.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private final List<CartItem> cartItems = new ArrayList<>();

    protected Cart() {
    }

    public Cart(User user) {
        this.user = user;
    }

    public static Cart create(User user) {
        return new Cart(user);
    }

    public void addItem(CartItem cartItem) {
        cartItems.add(cartItem);
    }
}
