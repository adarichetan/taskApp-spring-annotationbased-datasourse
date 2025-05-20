package com.dss;

import com.dss.util.MyConfig;
import com.dss.view.View;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        TaskApp bean = context.getBean(TaskApp.class);
        bean.getX();

        View view = context.getBean("view", View.class);
        view.showMenu();
    }
}