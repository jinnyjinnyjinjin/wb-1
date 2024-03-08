package com.example.layeredarchitecture.domain.cart;

import com.example.layeredarchitecture.infrastructure.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CartReader {

    private final CartRepository cartRepository;

    public Cart readByUserId(Long userId) {
        return cartRepository.findByUser_Id(userId)
                .orElseThrow(() -> new IllegalArgumentException("장바구니를 찾을 수 없습니다. userId: " + userId));
    }
}
