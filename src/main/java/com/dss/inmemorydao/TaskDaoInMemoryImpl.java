package com.dss.inmemorydao;

import com.dss.dao.TaskDao;
import com.dss.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

import java.util.List;

@Repository("taskInMemory")
public class TaskDaoInMemoryImpl implements TaskDao {
    List<Task> tasks = new ArrayList<>();

    @Override
    public void save(Task task) {
        tasks.add(task);
    }

    @Override
    public Task findById(Long id) {
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Task> findAll() {
        return tasks;
    }
}
