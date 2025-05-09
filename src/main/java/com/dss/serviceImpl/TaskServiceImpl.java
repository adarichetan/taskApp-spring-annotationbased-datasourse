package com.dss.serviceImpl;

import com.dss.dao.TaskDao;
import com.dss.model.Task;
import com.dss.service.TaskService;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    @Qualifier("taskInMemory")
    TaskDao taskDao;

    public void setTaskDao(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public void createTask(Task task) {
        taskDao.save(task);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskDao.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskDao.findAll();
    }
}
