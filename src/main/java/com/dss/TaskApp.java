package com.dss;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class TaskApp {

    @Value("${welcome}")
    String x;


    public void getX() {
        System.out.println(x);
    }
}
