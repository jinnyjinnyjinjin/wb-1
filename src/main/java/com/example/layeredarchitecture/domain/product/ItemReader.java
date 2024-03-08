package com.example.layeredarchitecture.domain.product;

import com.example.layeredarchitecture.infrastructure.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemReader {

    private final ProductRepository productRepository;

    public Product readById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다. itemId: " + id));
    }
}
