package com.dss.view;

import com.dss.model.Task;
import com.dss.model.User;
import com.dss.service.TaskService;
import com.dss.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.lang.model.element.Name;
import java.util.List;
import java.util.Scanner;


public class View {
    private UserService userService;
    private TaskService taskService;

    public View(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        boolean hey = true;
        while(hey) {

            System.out.println("-------------------");
            System.out.println("     TASK APP  ");
            System.out.println("-------------------");
            System.out.println("1. CREATE USER");
            System.out.println("2. CREATE TASK");
            System.out.println("3. GET ALL USERS");
            System.out.println("4. GET ALL TASKS");
            System.out.println("5. EXIT");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> registerUser();
                case 2 -> createTask();
                case 3 -> getAllUsers();
                case 4 -> getAllTasks();
                case 5 -> {
                    hey=false;
                    break;
                }
                default -> System.out.println("Goodbye!");

            }
        }
    }

    public void getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        System.out.println(allUsers);
    }

    public void getAllTasks() {
        List<Task> allTasks = taskService.getAllTasks();
        System.out.println(allTasks);
    }

    public void registerUser() {
        System.out.println("Enter your name: ");

        String name = scanner.next();

        User user = new User();
        user.setName(name);

        System.out.println("User created!");
        userService.registerUser(user);
    }

    public void createTask() {
        System.out.print("Enter task name: ");
        String name = scanner.next();
        System.out.print("Enter task status: ");
        String status = scanner.next();
        System.out.print("Enter User ID to assign this task to: ");
        Long userId = scanner.nextLong();

        User user = userService.getUserById(userId);
        if (user == null) {
            System.out.println("User not found. Task not created.");
            return;
        }
        Task task = new Task();
        task.setName(name);
        task.setStatus(status);
        task.setUser(user);

        taskService.createTask(task);
        System.out.println("Task created!");
    }
}

