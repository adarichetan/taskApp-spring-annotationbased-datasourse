package com.dss.dao;

import com.dss.model.User;

import java.util.List;

public interface UserDao {
    void save(User user);
    User findById(Long id);
    List<User> findAll();

}
