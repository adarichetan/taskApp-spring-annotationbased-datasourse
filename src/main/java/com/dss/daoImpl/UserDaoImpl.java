package com.dss.daoImpl;

import com.dss.dao.UserDao;
import com.dss.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import lombok.NoArgsConstructor;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private EntityManager entityManager;

    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> fromUsers = entityManager.createQuery("FROM User", User.class);
        return fromUsers.getResultList();
    }
}
