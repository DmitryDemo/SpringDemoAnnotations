package com.spring.annotations;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        TennisCoach tennisCoach = context.getBean("tennisCoach", TennisCoach.class);
        HockeyCoach hockeyCoach = context.getBean("hockeyCoach", HockeyCoach.class);

//        System.out.println(theCoach.getDailyWorkout());
//        System.out.println(theCoach.getDailyFortune());
//        System.out.println(tennisCoach.getCoachContacts());

        System.out.println(hockeyCoach.getDailyFortune());

        context.close();
    }
}
