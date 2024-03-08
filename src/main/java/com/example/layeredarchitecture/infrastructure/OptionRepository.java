package com.example.layeredarchitecture.infrastructure;

import com.example.layeredarchitecture.domain.item.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option, Long> {
}
