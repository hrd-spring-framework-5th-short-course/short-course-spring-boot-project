package com.example.demopojo.services.impl;

import com.example.demopojo.models.User;
import com.example.demopojo.repositories.UserRepository;
import com.example.demopojo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplimentation  implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {

//        Business rules

        return this.userRepository.getAll();
    }

    @Override
    public boolean save(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User getOne(Integer id) {

        return userRepository.getOne(id);
    }


    @Override
    public boolean update(User user) {
        return this.userRepository.update(user);
    }

    @Override
    public boolean delete(Integer id) {
        return this.userRepository.delete(id);
    }
}
