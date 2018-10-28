package com.example.demopojo.services;

import com.example.demopojo.models.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getOne(Integer id);

    boolean save(User user);

    boolean update(User user);

    boolean delete(Integer id);

}
