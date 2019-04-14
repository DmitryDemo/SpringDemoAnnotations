package com.spring.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeFourApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach hockeyCoach = context.getBean("hockeyCoach", Coach.class);

        System.out.println(hockeyCoach.getDailyWorkout());

        context.close();
    }
}
