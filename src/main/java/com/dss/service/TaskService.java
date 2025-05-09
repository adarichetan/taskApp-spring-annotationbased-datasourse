package com.dss.service;

import com.dss.model.Task;

import java.util.List;

public interface TaskService {

    void createTask(Task task);

    Task getTaskById(Long id);

    List<Task> getAllTasks();
}

