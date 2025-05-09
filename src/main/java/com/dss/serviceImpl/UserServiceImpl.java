package com.dss.serviceImpl;

import com.dss.dao.UserDao;
import com.dss.model.User;
import com.dss.service.UserService;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@NoArgsConstructor
public class UserServiceImpl implements UserService {

    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void registerUser(User user) {
        userDao.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }
}
