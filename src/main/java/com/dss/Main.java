package com.dss;

import com.dss.view.View;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
/*
        User user = context.getBean("user", User.class);
        Task task = context.getBean("task", Task.class);

        TaskServiceOld taskService = context.getBean("taskService", TaskServiceOld.class);
        taskService.assignTask(user, task);

        ReportGenerator reportGenerator = context.getBean("reportGenerator",ReportGenerator.class);
        reportGenerator.generate("Freshers report");

        ReportGenerator reportGenerator2 = context.getBean("reportGenerator",ReportGenerator.class);
        reportGenerator2.generate("Associate report");*/
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        View view = context.getBean("view", View.class);
        view.showMenu();
    }
}