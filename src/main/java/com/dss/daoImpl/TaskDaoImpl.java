package com.dss.daoImpl;

import com.dss.dao.TaskDao;
import com.dss.model.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter
@NoArgsConstructor
public class TaskDaoImpl implements TaskDao {
    private EntityManager entityManager;

    @Override
    public void save(Task task) {
        entityManager.getTransaction().begin();
        entityManager.persist(task);
        entityManager.getTransaction().commit();
    }

    @Override
    public Task findById(Long id) {
        return entityManager.find(Task.class, id);
    }

    @Override
    public List<Task> findAll() {
        TypedQuery<Task> fromTasks = entityManager.createQuery("FROM Task", Task.class);
        return fromTasks.getResultList();
    }
}
