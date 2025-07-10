package com.shoppit.user_service.service;


import com.shoppit.user_service.entity.User;

import java.util.Optional;

public interface UserService {

    User createUser(User user);
    Optional<User> getUserById(Long id);
    User updateUser(User user);
    void deleteUser(Long id);
    Optional<User> findByEmail(String email);
}
