package com.example.layeredarchitecture.infrastructure;

import com.example.layeredarchitecture.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
