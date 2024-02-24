package com.example.layeredarchitecture.infra;

import com.example.layeredarchitecture.domain.cart.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
