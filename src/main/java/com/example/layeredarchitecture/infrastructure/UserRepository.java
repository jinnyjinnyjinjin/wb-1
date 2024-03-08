package com.example.layeredarchitecture.infrastructure;

import com.example.layeredarchitecture.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
