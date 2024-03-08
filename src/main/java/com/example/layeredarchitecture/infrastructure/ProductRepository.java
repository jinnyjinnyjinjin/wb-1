package com.example.layeredarchitecture.infrastructure;

import com.example.layeredarchitecture.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
