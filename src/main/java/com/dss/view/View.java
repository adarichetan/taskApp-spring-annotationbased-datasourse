package com.dss.view;

import com.dss.model.Task;
import com.dss.model.User;
import com.dss.service.TaskService;
import com.dss.service.UserService;
import com.dss.validator.UserValidator;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import java.util.List;
import java.util.Scanner;

@Named
public class View {

    private UserService userService;
    private TaskService taskService;
    private UserValidator userValidator;

    @Inject
    public View(TaskService taskService, UserService userService, UserValidator userValidator) {
        this.taskService = taskService;
        this.userService = userService;
        this.userValidator = userValidator;
    }

    Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        boolean hey = true;
        while (hey) {

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
            scanner.nextLine();

            switch (choice) {
                case 1 -> registerUser();
                case 2 -> createTask();
                case 3 -> getAllUsers();
                case 4 -> getAllTasks();
                case 5 -> {
                    hey = false;
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

        String name = scanner.nextLine();
        User user = new User();
        user.setName(name);
//        user.setName("");

        Errors errors = new BeanPropertyBindingResult(user, "name");
        userValidator.validate(user, errors);

        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(error1 -> System.out.println("Error:"+ error1.getDefaultMessage()));

        } else {
            userService.registerUser(user);
            System.out.println("User created!");
        }
    }

    public void createTask() {
        System.out.print("Enter task name: ");
        String name = scanner.next();
        System.out.print("Enter task status: ");
        String status = scanner.next();
        System.out.print("Enter User ID to assign this task to: ");
        List<User> allUsers = userService.getAllUsers();
        System.out.println(allUsers);

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

