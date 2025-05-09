package com.dss.inmemorydao;

import com.dss.dao.UserDao;
import com.dss.model.Task;
import com.dss.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("userInMemory")
public class UserDaoInMemoryImpl implements UserDao {
    List<User> users = new ArrayList<>();

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public User findById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> findAll() {
        return users;
    }
}
