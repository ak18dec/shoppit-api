package com.shoppit.user_service.service;


import com.shoppit.user_service.entity.User;

import java.util.Optional;

public interface UserService {

    User registerUser(User user);
    Optional<User> getUserById(Long id);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    Optional<User> findByEmail(String email);
}
