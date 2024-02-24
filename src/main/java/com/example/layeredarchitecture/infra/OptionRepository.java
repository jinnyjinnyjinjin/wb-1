package com.example.layeredarchitecture.infra;

import com.example.layeredarchitecture.domain.item.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option, Long> {
}
