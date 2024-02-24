package com.example.layeredarchitecture.infra;

import com.example.layeredarchitecture.domain.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
