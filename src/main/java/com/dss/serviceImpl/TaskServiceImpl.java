package com.dss.serviceImpl;

import com.dss.dao.TaskDao;
import com.dss.model.Task;
import com.dss.service.TaskService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@NoArgsConstructor

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
//    @Qualifier("taskInMemory")
    @Qualifier("hbTaskDao")
    TaskDao taskDao;

    public void setTaskDao(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    @Transactional
    public void createTask(Task task) {

        taskDao.save(task);
    }

    @Override
    @Transactional
    public Task getTaskById(Long id) {
        return taskDao.findById(id);
    }

    @Override
    @Transactional
    public List<Task> getAllTasks() {
        return taskDao.findAll();
    }
}
