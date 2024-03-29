package com.example.layeredarchitecture.domain.product;

import com.example.layeredarchitecture.infrastructure.OptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OptionReader {

    private final OptionRepository optionRepository;

    public Option readById(Long id) {
        return optionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("옵션을 찾을 수 없습니다. id: " + id));
    }
}
