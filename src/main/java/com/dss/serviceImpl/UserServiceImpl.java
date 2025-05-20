package com.dss.serviceImpl;

import com.dss.dao.UserDao;
import com.dss.model.User;
import com.dss.service.UserService;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@NoArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    UserDao userDao;

    @Autowired
//    @Qualifier("userInMemory")

    @Qualifier("hbUserDao")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void registerUser(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public User getUserById(Long id) {
        return userDao.findById(id);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.findAll();
    }
}
