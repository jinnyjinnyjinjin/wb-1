package com.example.layeredarchitecture.domain.item;

import com.example.layeredarchitecture.infra.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemReader {

    private final ItemRepository itemRepository;

    public Item readById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다. itemId: " + id));
    }
}
