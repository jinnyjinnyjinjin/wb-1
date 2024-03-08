package com.example.layeredarchitecture.infra;

import com.example.layeredarchitecture.domain.cart.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
