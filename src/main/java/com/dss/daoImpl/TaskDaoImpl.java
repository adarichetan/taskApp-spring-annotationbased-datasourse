package com.dss.daoImpl;

import com.dss.dao.TaskDao;
import com.dss.model.Task;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@NoArgsConstructor
@Repository("hbTaskDao")
public class TaskDaoImpl implements TaskDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Task task) {
        entityManager.persist(task);
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
