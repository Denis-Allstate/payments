package com.allstate.payments.service;

import com.allstate.payments.domain.User;
import com.allstate.payments.domain.UserDTO;

import java.util.List;

public interface UserService {

    public void save(User user);

    public User findUser(String username);

    public List<UserDTO> getAllUsers();
}
