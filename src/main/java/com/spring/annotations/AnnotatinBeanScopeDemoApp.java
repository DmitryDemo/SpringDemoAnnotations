package com.spring.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotatinBeanScopeDemoApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

        boolean areCoachesEqual = (theCoach == alphaCoach);

        System.out.println("Are coaches equal? = " + areCoachesEqual);
        System.out.println("Memory location of 'theCoach: " + theCoach);
        System.out.println("Memory location of 'alphaCoach: " + alphaCoach);

        context.close();
    }
}
