package com.dss.dao;

import com.dss.model.Task;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface TaskDao {
    void save(Task task);

    Task findById(Long id);

    List<Task> findAll();
}
