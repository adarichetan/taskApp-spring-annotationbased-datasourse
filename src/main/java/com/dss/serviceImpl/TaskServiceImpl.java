package com.dss.serviceImpl;

import com.dss.dao.TaskDao;
import com.dss.model.Task;
import com.dss.service.TaskService;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@NoArgsConstructor
@Setter
public class TaskServiceImpl implements TaskService {

    TaskDao taskDao;
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
