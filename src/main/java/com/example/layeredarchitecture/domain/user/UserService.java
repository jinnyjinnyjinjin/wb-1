package com.example.layeredarchitecture.domain.user;

import com.example.layeredarchitecture.infrastructure.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long create(String name) {
        User user = User.create(name);
        return userRepository.save(user).getId();
    }
}
