package com.allstate.payments.service;

import com.allstate.payments.data.UserRepository;
import com.allstate.payments.domain.User;
import com.allstate.payments.domain.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class BootstrapService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PostConstruct
    public void createInitialUsers(){
        if (userRepository.count()==0){
            User user1 = new User("Denis", "Denis", "pass1", UserRole.USER);
            User user2 = new User("Sally", "Sally", "pass2", UserRole.MANAGER);
            userService.save(user1);
            userService.save(user2);
        }

    }
}
