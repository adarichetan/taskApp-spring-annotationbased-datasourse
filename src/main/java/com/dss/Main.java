package com.dss;

import com.dss.util.MyConfig;
import com.dss.view.View;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        TaskApp bean = context.getBean(TaskApp.class);
        bean.getX();

        View view = context.getBean("view", View.class);
        view.showMenu();

    }
}